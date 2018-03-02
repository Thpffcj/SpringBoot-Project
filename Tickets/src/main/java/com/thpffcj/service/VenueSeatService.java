package com.thpffcj.service;

import com.thpffcj.web.dto.VenueSeatDto;
import com.thpffcj.web.form.VenueSeatForm;

/**
 * Created by Thpffcj on 2018/3/2.
 */
public interface VenueSeatService {

    ServiceResult<VenueSeatDto> addSeat(VenueSeatForm venueSeatForm);
}
