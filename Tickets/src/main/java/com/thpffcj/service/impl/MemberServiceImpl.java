package com.thpffcj.service.impl;

import com.thpffcj.entity.Member;
import com.thpffcj.entity.VenueSeat;
import com.thpffcj.repository.MemberRepository;
import com.thpffcj.service.MemberService;
import com.thpffcj.service.OrderService;
import com.thpffcj.service.ShowService;
import com.thpffcj.service.VenueSeatService;
import com.thpffcj.service.result.ServiceMultiResult;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.web.dto.OrderDto;
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
    private MemberRepository memberRepository;

    @Autowired
    private ShowService showService;

    @Autowired
    private VenueSeatService venueSeatService;

    @Autowired
    private OrderService orderService;

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
}
