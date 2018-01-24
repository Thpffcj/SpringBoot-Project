package com.thpffcj.dao;

import com.thpffcj.entity.Show;

/**
 * Created by Thpffcj on 2018/1/21.
 */
public interface VenueDao {

    /**
     * 发布计划(未来一个时间段)
     * @param show
     * @return
     */
    int insertShow(Show show);
}
