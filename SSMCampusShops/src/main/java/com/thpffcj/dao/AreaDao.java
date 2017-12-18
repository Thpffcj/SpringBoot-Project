package com.thpffcj.dao;

import com.thpffcj.entity.Area;

import java.util.List;

/**
 * Created by Thpffcj on 2017/12/18.
 */
public interface AreaDao {

    /**
     * 列出地域列表
     * @return
     */
    List<Area> queryArea();
}
