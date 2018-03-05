package com.thpffcj.service.impl;

import com.thpffcj.base.OrderStatus;
import com.thpffcj.entity.Order;
import com.thpffcj.entity.Show;
import com.thpffcj.repository.OrderRepository;
import com.thpffcj.service.OrderService;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.service.ShowService;
import com.thpffcj.service.VenueService;
import com.thpffcj.web.dto.OrderDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Thpffcj on 2018/3/2.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ShowService showService;

    @Autowired
    private VenueService venueService;

    /**
     * 创建订单
     * @param memberId
     * @param showId
     * @param seatName
     * @param number
     * @return
     */
    @Override
    public ServiceResult<OrderDto> createOrder(Long memberId, Long showId, String seatName, int number) {
        Long venueId = 1000000L;

        Order order = new Order();
        order.setMemberId(memberId);
        order.setShowId(showId);
        order.setCreateTime(new Date());
        order.setSeatName(seatName);
        order.setNumber(number);
        order.setStatus(OrderStatus.PASSES.getValue());
        orderRepository.save(order);

        OrderDto orderDto = modelMapper.map(order, OrderDto.class);
        Show show = showService.getShowByShowId(showId);
        orderDto.setShowName(show.getName());
        orderDto.setShowTime(show.getPerformanceTime());
        orderDto.setVenueName(venueService.getVenueByVenueId(venueId).getName());

        return new ServiceResult<OrderDto>(true, null, orderDto);
    }
}
