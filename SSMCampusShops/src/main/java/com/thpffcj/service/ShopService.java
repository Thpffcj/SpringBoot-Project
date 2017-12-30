package com.thpffcj.service;

import com.thpffcj.dto.ShopExecution;
import com.thpffcj.entity.Shop;

import java.io.InputStream;

/**
 * Created by Thpffcj on 2017/12/19.
 */
public interface ShopService {

    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName);
}
