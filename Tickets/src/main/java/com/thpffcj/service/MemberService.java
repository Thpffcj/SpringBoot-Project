package com.thpffcj.service;

import com.thpffcj.service.result.ServiceMultiResult;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.web.dto.OrderDto;

/**
 * Created by Thpffcj on 2018/1/30.
 */
public interface MemberService {

    ServiceResult<OrderDto> seatReservation(Long memberId, Long showId, String seatName, int number);
}
