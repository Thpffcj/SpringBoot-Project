package com.thpffcj.service;

import com.thpffcj.BaseTest;
import com.thpffcj.entity.Show;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Thpffcj on 2018/3/2.
 */
public class ShowServiceTest extends BaseTest {

    @Autowired
    private ShowService showService;

    @Test
    public void releasePlan() {
    }

    @Test
    public void getShowByShowId() {
        Show show = showService.getShowByShowId(1L);
        System.out.println(show);
    }
}