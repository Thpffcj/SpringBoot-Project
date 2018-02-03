package com.thpffcj.dao;

import com.thpffcj.entity.ProductImg;

import java.util.List;

/**
 * Created by Thpffcj on 2018/1/6.
 */
public interface ProductImgDao {

    /**
     * 批量添加商品详情图片
     * @param productImgList
     * @return
     */
    int batchInsertProductImg(List<ProductImg> productImgList);

    /**
     * 删除指定商品下的所有详情图
     * @param productId
     * @return
     */
    int deleteProductImgByProductId(long productId);
}
