package com.thpffcj.service.impl;

import com.thpffcj.entity.Show;
import com.thpffcj.repository.ShowRepository;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.service.ShowService;
import com.thpffcj.web.dto.ShowDto;
import com.thpffcj.web.form.ShowForm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Thpffcj on 2018/3/2.
 */
@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ShowRepository showRepository;

    /**
     * 发布演出计划
     * @param showForm
     * @return
     */
    @Override
    public ServiceResult<ShowDto> releasePlan(ShowForm showForm) {
        Show show = new Show();
        modelMapper.map(showForm, show);

        showRepository.save(show);

        ShowDto showDto = modelMapper.map(show, ShowDto.class);
        return new ServiceResult<ShowDto>(true, null, showDto);
    }

    /**
     * 通过showId查找演出
     * @param showId
     * @return
     */
    @Override
    public Show getShowByShowId(Long showId) {
        return showRepository.findShowById(showId);
    }
}
