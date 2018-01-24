package com.thpffcj.service;

import com.thpffcj.dto.ImageHolder;
import com.thpffcj.dto.ProductExecution;
import com.thpffcj.entity.Product;
import com.thpffcj.exceptions.ProductOperationException;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Thpffcj on 2018/1/7.
 */
public interface ProductService {

    /**
     * 添加商品信息以及图片处理
     * @param product
     * @param thumbnail
     * @param productImgList
     * @return
     * @throws ProductOperationException
     */
    ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList) throws ProductOperationException;
}
