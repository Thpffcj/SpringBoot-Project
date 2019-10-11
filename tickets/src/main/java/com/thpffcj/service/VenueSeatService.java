package com.thpffcj.service;

import com.thpffcj.entity.VenueSeat;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.web.dto.VenueSeatDto;
import com.thpffcj.web.form.VenueSeatForm;

/**
 * Created by Thpffcj on 2018/3/2.
 */
public interface VenueSeatService {

    ServiceResult<VenueSeatDto> addSeat(VenueSeatForm venueSeatForm);

    void updateSeat(Long id, int remainingSeat);

    VenueSeat getSeat(Long venueId, String seatName);
}
