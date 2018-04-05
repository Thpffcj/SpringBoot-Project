package com.thpffcj.service.impl;

import com.thpffcj.base.LevelRules;
import com.thpffcj.base.OrderStatus;
import com.thpffcj.entity.Order;
import com.thpffcj.entity.Show;
import com.thpffcj.repository.OrderRepository;
import com.thpffcj.service.MemberService;
import com.thpffcj.service.OrderService;
import com.thpffcj.service.result.ServiceMultiResult;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.service.ShowService;
import com.thpffcj.service.VenueService;
import com.thpffcj.web.dto.OrderDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private MemberService memberService;

    /**
     * 创建订单
     * @param memberId
     * @param showId
     * @param seatName
     * @param number
     * @return
     */
    @Override
    public ServiceResult<OrderDto> createOrder(Long memberId, Long showId, String seatName, int number, double total) {
        Long venueId = showService.getShowByShowId(showId).getVenueId();

        Order order = new Order();
        order.setMemberId(memberId);
        order.setVenueId(venueId);
        order.setShowId(showId);
        order.setCreateTime(new Date());
        order.setSeatName(seatName);
        order.setNumber(number);
        order.setTotal(total);
        order.setDiscountPrice(LevelRules.getDiscountByLevel(
                memberService.getMemberProfile(memberId).getResult().getLevel()) * total);
        order.setStatus(OrderStatus.BOOK.getValue());
        orderRepository.save(order);

        OrderDto orderDto = modelMapper.map(order, OrderDto.class);
        Show show = showService.getShowByShowId(showId);
        orderDto.setShowName(show.getName());
        orderDto.setShowTime(show.getPerformanceTime());
        orderDto.setVenueName(venueService.getVenueByVenueId(venueId).getName());
        orderDto.setDiscount(LevelRules.getDiscountByLevel(
                memberService.getMemberProfile(memberId).getResult().getLevel()));

        return new ServiceResult<OrderDto>(true, null, orderDto);
    }

    /**
     * 改变订单状态
     * @param orderId
     * @param status
     * @return
     */
    @Transactional
    @Override
    public ServiceResult<OrderDto> changeOrderStatus(Long orderId, int status) {
        orderRepository.updateStatus(orderId, status);
        // TODO
        return null;
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findOne(orderId);
    }

    @Override
    public ServiceMultiResult<OrderDto> getAllBookOrder(Long memberId) {
        List<OrderDto> result = new ArrayList<>();
        List<Order> orders = orderRepository.getAllByMemberIdAndStatus(memberId, OrderStatus.PAY.getValue());
        result = wrapOrder(orders);
        return new ServiceMultiResult<>(result.size(), result);
    }

    @Override
    public ServiceMultiResult<OrderDto> getAllCheckOrder(Long memberId) {
        List<OrderDto> result = new ArrayList<>();
        List<Order> orders = orderRepository.getAllByMemberIdAndStatus(memberId, OrderStatus.CHECK.getValue());
        result = wrapOrder(orders);
        return new ServiceMultiResult<>(result.size(), result);
    }

    @Override
    public ServiceMultiResult<OrderDto> getAllRefundOrder(Long memberId) {
        List<OrderDto> result = new ArrayList<>();
        List<Order> orders = orderRepository.getAllByMemberIdAndStatus(memberId, OrderStatus.REFUND.getValue());
        result = wrapOrder(orders);
        return new ServiceMultiResult<>(result.size(), result);
    }

    @Override
    public ServiceMultiResult<OrderDto> getAllVenueBookOrder(Long venueId) {
        List<OrderDto> result = new ArrayList<>();
        List<Order> orders = orderRepository.getAllByVenueIdAndStatus(venueId, OrderStatus.PAY.getValue());
        result = wrapOrder(orders);
        return new ServiceMultiResult<>(result.size(), result);
    }

    @Override
    public ServiceMultiResult<OrderDto> getAllVenueRefundOrder(Long venueId) {
        List<OrderDto> result = new ArrayList<>();
        List<Order> orders = orderRepository.getAllByVenueIdAndStatus(venueId, OrderStatus.REFUND.getValue());
        result = wrapOrder(orders);
        return new ServiceMultiResult<>(result.size(), result);
    }

    /**
     * Order转OrderDto
     * @param orders
     * @return
     */
    private List<OrderDto> wrapOrder(List<Order> orders) {
        List<OrderDto> result = new ArrayList<>();
        orders.forEach(order -> {
            OrderDto orderDto = modelMapper.map(order, OrderDto.class);
            Show show = showService.getShowByShowId(order.getShowId());
            orderDto.setShowName(show.getName());
            orderDto.setShowTime(show.getPerformanceTime());
            orderDto.setVenueName(venueService.getVenueByVenueId(show.getVenueId()).getName());
            result.add(orderDto);
        });
        return result;
    }
}
