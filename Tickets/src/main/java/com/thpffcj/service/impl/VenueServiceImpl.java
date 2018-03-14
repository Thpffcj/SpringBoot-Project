package com.thpffcj.service.impl;

import com.thpffcj.base.VenueStatus;
import com.thpffcj.entity.Venue;
import com.thpffcj.repository.VenueRepository;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.service.VenueService;
import com.thpffcj.web.dto.VenueDto;
import com.thpffcj.web.form.VenueForm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 注册场馆
     * @param venueForm
     * @return
     */
    @Override
    public ServiceResult save(VenueForm venueForm) {
        Venue venue = new Venue();
        modelMapper.map(venueForm, venue);
        // TODO 生成场馆编号
        venue.setStatus(VenueStatus.NOT_AUDITED.getValue());

        venueRepository.save(venue);

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
    @Override
    public void updateVenueStatus(Long venueId, int status) {
        venueRepository.updateStatus(venueId, status);
    }
}
