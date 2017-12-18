package com.thpffcj.service;

import com.thpffcj.BaseTest;
import com.thpffcj.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Thpffcj on 2017/12/18.
 */
public class AreaServiceTest extends BaseTest {

    @Autowired
    private AreaService areaService;

    @Test
    public void getAreaList() {
        List<Area> areaList = areaService.getAreaList();
        assertEquals("东苑", areaList.get(0).getAreaName());
    }
}