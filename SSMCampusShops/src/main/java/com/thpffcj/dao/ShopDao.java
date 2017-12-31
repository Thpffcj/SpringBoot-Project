package com.thpffcj.dao;

import com.thpffcj.entity.Shop;

import java.util.List;

/**
 * Created by Thpffcj on 2017/12/18.
 */
public interface ShopDao {

    /**
     * 通过 shop id 查询店铺
     * @param shopId
     * @return
     */
    Shop queryByShopId(long shopId);

    /**
     * 新增店铺
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     */
    int updateShop(Shop shop);
}
