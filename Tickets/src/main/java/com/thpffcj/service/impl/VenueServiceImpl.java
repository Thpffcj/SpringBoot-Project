package com.thpffcj.service.impl;

import com.thpffcj.entity.Venue;
import com.thpffcj.repository.VenueRepository;
import com.thpffcj.service.ServiceResult;
import com.thpffcj.service.VenueService;
import com.thpffcj.web.dto.VenueDto;
import com.thpffcj.web.form.VenueForm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        venueRepository.save(venue);

        VenueDto venueDto = modelMapper.map(venue, VenueDto.class);

        return new ServiceResult<VenueDto>(true, null, venueDto);
    }
}
