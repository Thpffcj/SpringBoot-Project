package com.thpffcj.service;

import com.thpffcj.entity.ShopCategory;

import java.util.List;

/**
 * Created by Thpffcj on 2017/12/30.
 */
public interface ShopCategoryService {

    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
