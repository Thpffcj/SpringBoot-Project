package com.thpffcj.service;

import com.thpffcj.entity.Show;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.web.dto.ShowDto;
import com.thpffcj.web.form.ShowForm;

/**
 * Created by Thpffcj on 2018/3/2.
 */
public interface ShowService {

    ServiceResult<ShowDto> releasePlan(ShowForm showForm);

    Show getShowByShowId(Long showId);
}
