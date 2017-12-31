package com.thpffcj.service;

import com.thpffcj.dto.ShopExecution;
import com.thpffcj.entity.Shop;

import java.io.InputStream;

/**
 * Created by Thpffcj on 2017/12/19.
 */
public interface ShopService {

    /**
     * 通过店铺Id获取店铺信息
     * @param shopId
     * @return
     */
    Shop getByShopId(long shopId);

    /**
     * 更新店铺信息，包括图片的处理
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     */
    ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName);

    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName);
}
