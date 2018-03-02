package com.thpffcj.service.impl;

import com.thpffcj.entity.VenueSeat;
import com.thpffcj.repository.VenueSeatRepository;
import com.thpffcj.service.ServiceResult;
import com.thpffcj.service.VenueSeatService;
import com.thpffcj.web.dto.VenueSeatDto;
import com.thpffcj.web.form.VenueSeatForm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Thpffcj on 2018/3/2.
 */
@Service
public class VenueSeatServiceImpl implements VenueSeatService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private VenueSeatRepository venueSeatRepository;

    @Override
    public ServiceResult<VenueSeatDto> addSeat(VenueSeatForm venueSeatForm) {
        VenueSeat venueSeat = new VenueSeat();
        modelMapper.map(venueSeatForm, venueSeat);

        venueSeat.setVenueId(1000000L);
        venueSeatRepository.save(venueSeat);

        VenueSeatDto venueSeatDto = modelMapper.map(venueSeat, VenueSeatDto.class);
        return new ServiceResult<VenueSeatDto>(true, null, venueSeatDto);
    }
}
