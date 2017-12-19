package com.thpffcj.dao;

import com.thpffcj.entity.Shop;

/**
 * Created by Thpffcj on 2017/12/18.
 */
public interface ShopDao {

    /**
     * 新增店铺
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     */
    int updateShop(Shop shop);
}
