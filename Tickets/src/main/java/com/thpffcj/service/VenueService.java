package com.thpffcj.service;

import com.thpffcj.web.dto.VenueDto;
import com.thpffcj.web.form.VenueForm;

/**
 * Created by Thpffcj on 2018/2/9.
 */
public interface VenueService {

    ServiceResult<VenueDto> save(VenueForm venueForm);

}
