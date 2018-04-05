package com.thpffcj.service.impl;

import com.thpffcj.base.ShowStatus;
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
import org.springframework.transaction.annotation.Transactional;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
     * @param venueId
     * @param showForm
     * @return
     */
    @Override
    public ServiceResult<ShowDto> releasePlan(Long venueId, ShowForm showForm) {
        Show show = new Show();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date performanceTime = formatter.parse(showForm.getTime(), pos);

        modelMapper.map(showForm, show);
        show.setVenueId(venueId);
        show.setPerformanceTime(performanceTime);

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
    public Show getShowByShowName(String showName) {
        return showRepository.findShowByName(showName);
    }

    /**
     * 找到所有未结算的演出
     * @return
     */
    @Override
    public List<Show> getUnsettlementShow() {
        return showRepository.getAllByStatus(ShowStatus.UNSETTLEMENT.getValue());
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

    /**
     * 修改演出状态
     * @param showId
     * @param status
     */
    @Transactional
    @Override
    public void updateShowStatus(Long showId, int status) {
        showRepository.updateStatus(showId, status);
    }
}
