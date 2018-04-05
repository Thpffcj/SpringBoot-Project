package com.thpffcj.service.impl;

import com.thpffcj.base.OrderStatus;
import com.thpffcj.base.VenueStatus;
import com.thpffcj.entity.Venue;
import com.thpffcj.repository.VenueRepository;
import com.thpffcj.service.OrderService;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.service.VenueService;
import com.thpffcj.web.dto.OrderDto;
import com.thpffcj.web.dto.VenueDto;
import com.thpffcj.web.form.VenueForm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Thpffcj on 2018/2/9.
 */
@Service
public class VenueServiceImpl implements VenueService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private OrderService orderService;

    /**
     * 注册场馆
     * @param venueForm
     * @return
     */
    @Override
    public ServiceResult save(VenueForm venueForm) {
        Venue venue = new Venue();
        modelMapper.map(venueForm, venue);
        venue.setStatus(VenueStatus.NOT_AUDITED.getValue());

        venueRepository.save(venue);

        VenueDto venueDto = modelMapper.map(venue, VenueDto.class);

        return new ServiceResult<VenueDto>(true, null, venueDto);
    }

    /**
     * 修改场馆信息
     * @param venueId
     * @param name
     * @param address
     * @param description
     * @return
     */
    @Override
    @Transactional
    public ServiceResult<VenueDto> edit(Long venueId, String name, String address, String description) {
        venueRepository.updateVenue(venueId, name, address, description);
        venueRepository.updateStatus(venueId, VenueStatus.NOT_AUDITED.getValue());

        Venue venue = venueRepository.findById(venueId);
        VenueDto venueDto = modelMapper.map(venue, VenueDto.class);
        return new ServiceResult<VenueDto>(true, null, venueDto);
    }

    /**
     * 根据venueId查找场馆
     * @param venueId
     * @return
     */
    @Override
    public Venue getVenueByVenueId(Long venueId) {
        return venueRepository.findById(venueId);
    }

    /**
     * 根据场馆管理员查询场馆
     * @param managerId
     * @return
     */
    @Override
    public Venue getVenueByManagerId(Long managerId) {
        return venueRepository.findByManagerId(managerId);
    }

    @Override
    public ServiceResult<VenueDto> getVenueDtoByVenueId(Long venueId) {
        Venue venue = venueRepository.findById(venueId);
        VenueDto venueDto = null;
        if (venue != null) {
            venueDto =  modelMapper.map(venue, VenueDto.class);
        }
        return new ServiceResult<VenueDto>(true, null, venueDto);
    }

    /**
     * 根据状态查询场馆
     * @param status
     * @return
     */
    @Override
    public List<Venue> getVenueByStatus(int status) {
        return venueRepository.findAllByStatus(status);
    }

    /**
     * 修改场馆状态
     * @param venueId
     * @param status
     */
    @Transactional
    @Override
    public void updateVenueStatus(Long venueId, int status) {
        venueRepository.updateStatus(venueId, status);
    }

    /**
     * 检票
     * @param orderId
     * @return
     */
    @Override
    public ServiceResult<OrderDto> checkOrder(Long orderId) {
        return orderService.changeOrderStatus(orderId, OrderStatus.CHECK.getValue());
    }
}
