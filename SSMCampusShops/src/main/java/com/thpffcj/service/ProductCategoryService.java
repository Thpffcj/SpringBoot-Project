package com.thpffcj.service;

import com.thpffcj.dto.ProductCategoryExecution;
import com.thpffcj.entity.ProductCategory;
import com.thpffcj.exceptions.ProductCategoryOperationException;

import java.util.List;

/**
 * Created by Thpffcj on 2017/12/31.
 */
public interface ProductCategoryService {

    /**
     * 查询指定某个店铺下的所有商品类别信息
     * @param shopId
     * @return
     */
    List<ProductCategory> getProductCategoryList(long shopId);

    /**
     *
     * @param productCategoryList
     * @return
     */
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList);

    /**
     * 将此类别下的商品里的类别id置为空，再删除掉该商品类别
     * @param productCategoryId
     * @param shopId
     * @return
     * @throws ProductCategoryOperationException
     */
    ProductCategoryExecution deleteProductCategoty(long productCategoryId, long shopId) throws ProductCategoryOperationException;
}
