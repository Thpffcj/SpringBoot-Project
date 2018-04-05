package com.thpffcj.service;

import com.thpffcj.entity.Member;
import com.thpffcj.service.result.ServiceMultiResult;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.web.dto.MemberDto;
import com.thpffcj.web.dto.OrderDto;

import java.util.List;

/**
 * Created by Thpffcj on 2018/1/30.
 */
public interface MemberService {

    ServiceResult<MemberDto> register(String mail, String password);

    void verification(String code);

    ServiceResult<MemberDto> login(String mail, String password);

    ServiceResult<MemberDto> getMemberProfile(Long id);

    /**
     * 会员选座购买
     * @param memberId
     * @param showId
     * @param seatName
     * @param number
     * @return
     */
    ServiceResult<OrderDto> seatReservation(Long memberId, Long showId, String seatName, int number);

    /**
     * 付款
     * @param orderId
     * @param account
     * @param password
     * @return
     */
    ServiceResult<OrderDto> payMoney(Long memberId, Long orderId, String account, String password);

    /**
     * 退票
     * @param orderId
     * @return
     */
    ServiceResult<OrderDto> refund(Long orderId);

    List<Member> listMember();

    ServiceResult<MemberDto> edit(Long id, String memberName, String password);

    void stopMember(Long memberId);
}
