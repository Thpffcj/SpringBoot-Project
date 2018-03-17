package com.thpffcj.service.impl;

import com.thpffcj.base.MemberStatus;
import com.thpffcj.entity.Member;
import com.thpffcj.entity.VenueSeat;
import com.thpffcj.repository.MemberRepository;
import com.thpffcj.service.MemberService;
import com.thpffcj.service.OrderService;
import com.thpffcj.service.ShowService;
import com.thpffcj.service.VenueSeatService;
import com.thpffcj.service.result.ServiceMultiResult;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.web.dto.MemberDto;
import com.thpffcj.web.dto.OrderDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Thpffcj on 2018/3/3.
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ShowService showService;

    @Autowired
    private VenueSeatService venueSeatService;

    @Autowired
    private OrderService orderService;

    @Override
    public ServiceResult<MemberDto> login(String mail, String password) {
        Member member = memberRepository.findByMailAndPasswordAndStatus(mail, password, MemberStatus.NORMAL.getValue());
        if (member == null) {
            return new ServiceResult<MemberDto>(false, "用户不存在");
        }
        MemberDto memberDto = modelMapper.map(member, MemberDto.class);
        return new ServiceResult<MemberDto>(true, null, memberDto);
    }

    /**
     * 查找用户信息
     * @param id
     * @return
     */
    @Override
    public ServiceResult<MemberDto> getMemberProfile(Long id) {
        Member member = memberRepository.findById(id);
        MemberDto memberDto = modelMapper.map(member, MemberDto.class);
        return new ServiceResult<MemberDto>(true, null, memberDto);
    }

    /**
     * 会员选座购买
     * @param memberId
     * @param showId
     * @param seatName
     * @param number
     * @return
     */
    @Override
    @Transactional
    public ServiceResult<OrderDto> seatReservation(Long memberId, Long showId, String seatName, int number) {
        Long venueId = showService.getShowByShowId(showId).getVenueId();
        VenueSeat venueSeat = venueSeatService.getSeat(venueId, seatName);
        int remainingSeat = venueSeat.getRemainingSeat();

        // 座位不够
        if (remainingSeat < number) {

        }

        // 更新剩余座位数
        remainingSeat = remainingSeat - number;
        venueSeatService.updateSeat(venueSeat.getId(), remainingSeat);

        return orderService.createOrder(memberId, showId, seatName, number);
    }

    @Override
    public List<Member> listMember() {
        return (List<Member>) memberRepository.findAll();
    }

    /**
     * 修改个人信息
     * @param id
     * @param memberName
     * @param password
     * @return
     */
    @Transactional
    @Override
    public ServiceResult<MemberDto> edit(Long id, String memberName, String password) {
        memberRepository.updateProfile(id, memberName, password);
        Member member = memberRepository.findById(id);
        MemberDto memberDto = modelMapper.map(member, MemberDto.class);
        return new ServiceResult<MemberDto>(true, null, memberDto);
    }

    /**
     * 停止会员服务
     * @param memberId
     */
    @Override
    public void stopMember(Long memberId) {
        memberRepository.updateStatus(memberId, MemberStatus.DELETED.getValue());
    }
}
