package com.thpffcj.service.impl;

import com.thpffcj.base.LevelRules;
import com.thpffcj.base.MemberStatus;
import com.thpffcj.base.OrderStatus;
import com.thpffcj.entity.Member;
import com.thpffcj.entity.Order;
import com.thpffcj.entity.VenueSeat;
import com.thpffcj.repository.MemberRepository;
import com.thpffcj.service.*;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.util.CodeUtil;
import com.thpffcj.util.MailUtil;
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

    @Autowired
    private PayService payService;

    /**
     * 注册
     * @param mail
     * @param password
     * @return
     */
    @Override
    public ServiceResult<MemberDto> register(String mail, String password) {
        Member member = new Member();
        member.setMail(mail);
        member.setPassword(password);
        member.setStatus(MemberStatus.TO_BE_VERIFIED.getValue());

        // 生成激活码
        String code = CodeUtil.generateUniqueCode();
        member.setCode(code);
        memberRepository.save(member);

        new Thread(new MailUtil(mail, code)).start();

        MemberDto memberDto = modelMapper.map(member, MemberDto.class);
        return new ServiceResult<MemberDto>(true, null, memberDto);
    }

    /**
     * 注册验证
     * @param code
     */
    @Transactional
    @Override
    public void verification(String code) {
        memberRepository.updateStatusByCode(code, MemberStatus.NORMAL.getValue());
    }

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
            return new ServiceResult<>(false, "座位不够");
        }

        // 更新剩余座位数
        remainingSeat = remainingSeat - number;
        venueSeatService.updateSeat(venueSeat.getId(), remainingSeat);

        double total = venueSeat.getPrice() * number;

        return orderService.createOrder(memberId, showId, seatName, number, total);
    }

    /**
     * 付款
     * @param orderId
     * @param account
     * @param password
     * @return
     */
    @Override
    @Transactional
    public ServiceResult<OrderDto> payMoney(Long memberId, Long orderId, String account, String password) {
        Member member = memberRepository.findById(memberId);
        double money = orderService.getOrderById(orderId).getDiscountPrice();
        // 扣钱
        payService.payOrder(account, password, money);

        // 更新消费金额
        memberRepository.updateConsumption(memberId, member.getConsumption() + money);

        // 目前等级
        int level = member.getLevel();
        // 达到下一等级所需金额则更新等级
        double grade = LevelRules.getGradeByLevel(level + 1);
        if (member.getConsumption() >= grade) {
            memberRepository.updateLevel(memberId, level + 1);
        }

        // 更新积分
        memberRepository.updatePoint(memberId, member.getPoint() + money * 0.1);

        // 更新订单状态
        ServiceResult<OrderDto> result = orderService.changeOrderStatus(orderId, OrderStatus.PAY.getValue());
        return result;
    }

    /**
     * 退票
     * @param orderId
     * @return
     */
    @Override
    @Transactional
    public ServiceResult<OrderDto> refund(Long orderId) {
        Order order = orderService.getOrderById(orderId);
        double money = order.getDiscountPrice();

        Member member = memberRepository.findById(order.getMemberId());
        // TODO 默认会员邮箱和支付宝邮箱账号一致
        payService.recharge(member.getMail(),money);

        // 更新消费金额
        memberRepository.updateConsumption(member.getId(), member.getConsumption() - money);

        // 目前等级
        int level = member.getLevel();
        // 达到下一等级所需金额则更新等级
        double grade = LevelRules.getGradeByLevel(level - 1);
        if (member.getConsumption() <= grade) {
            memberRepository.updateLevel(member.getId(), level - 1);
        }

        // 更新积分
        memberRepository.updatePoint(member.getId(), member.getPoint() - money * 0.1);

        // 更新订单状态
        ServiceResult<OrderDto> result = orderService.changeOrderStatus(orderId, OrderStatus.REFUND.getValue());

        return result;
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
    @Transactional
    public void stopMember(Long memberId) {
        memberRepository.updateStatus(memberId, MemberStatus.DELETED.getValue());
    }
}
