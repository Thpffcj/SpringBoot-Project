package com.thpffcj.service;

import com.thpffcj.entity.Order;
import com.thpffcj.service.result.ServiceMultiResult;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.web.dto.OrderDto;

/**
 * Created by Thpffcj on 2018/3/2.
 */
public interface OrderService {

    ServiceResult<OrderDto> createOrder(Long memberId, Long showId, String seatName, int number, double total);

    ServiceResult<OrderDto> changeOrderStatus(Long orderId, int status);

    Order getOrderById(Long orderId);

    ServiceMultiResult<OrderDto> getAllBookOrder(Long memberId);

    ServiceMultiResult<OrderDto> getAllCheckOrder(Long memberId);

    ServiceMultiResult<OrderDto> getAllRefundOrder(Long memberId);

    ServiceMultiResult<OrderDto> getAllVenueBookOrder(Long venueId);

    ServiceMultiResult<OrderDto> getAllVenueRefundOrder(Long venueId);
}
