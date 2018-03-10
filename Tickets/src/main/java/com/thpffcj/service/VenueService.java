package com.thpffcj.service;

import com.thpffcj.entity.Venue;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.web.dto.VenueDto;
import com.thpffcj.web.form.VenueForm;

import java.util.List;

/**
 * Created by Thpffcj on 2018/2/9.
 */
public interface VenueService {

    ServiceResult<VenueDto> save(VenueForm venueForm);

    Venue getVenueByVenueId(Long venueId);

    ServiceResult<VenueDto> getVenueDtoByVenueId(Long venueId);

    List<Venue> getVenueByStatus(int status);

    void updateVenueStatus(Long venueId, int status);

}
