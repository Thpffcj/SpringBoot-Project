package com.thpffcj.service.impl;

import com.thpffcj.dao.AreaDao;
import com.thpffcj.entity.Area;
import com.thpffcj.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Thpffcj on 2017/12/18.
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
