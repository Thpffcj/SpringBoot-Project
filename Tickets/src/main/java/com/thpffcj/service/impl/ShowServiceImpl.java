package com.thpffcj.service.impl;

import com.thpffcj.entity.Show;
import com.thpffcj.repository.ShowRepository;
import com.thpffcj.service.result.ServiceMultiResult;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.service.ShowService;
import com.thpffcj.web.dto.ShowDto;
import com.thpffcj.web.form.ShowForm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thpffcj on 2018/3/2.
 */
@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ShowRepository showRepository;

    public static final int SIZE_PER_PAGE_OF_SHOW = 6;

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

    @Override
    public ServiceResult<ShowDto> getShowDtoByShowId(Long showId) {
        ShowDto showDto = modelMapper.map(showRepository.findShowById(showId), ShowDto.class);
        return new ServiceResult<ShowDto>(true, null, showDto);
    }

    /**
     * 分页查询所有演出
     * @param page
     * @return
     */
    @Override
    public ServiceMultiResult<ShowDto> getShowsByPage(int page) {
        List<ShowDto> result = new ArrayList<>();
        Page<Show> pages;
        if (page >= 0) {
            pages = showRepository.findAll(new PageRequest(page, SIZE_PER_PAGE_OF_SHOW));
            pages.forEach(show -> {
                ShowDto showDto = modelMapper.map(show, ShowDto.class);
                result.add(showDto);
            });
        } else {
            showRepository.findAll().forEach(show -> {
                ShowDto showDto = modelMapper.map(show, ShowDto.class);
                result.add(showDto);
            });
        }
        return new ServiceMultiResult<>(result.size(), result);
    }
}
