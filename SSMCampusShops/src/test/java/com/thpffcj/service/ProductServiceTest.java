package com.thpffcj.service;

import com.thpffcj.BaseTest;
import com.thpffcj.dto.ImageHolder;
import com.thpffcj.dto.ProductExecution;
import com.thpffcj.entity.Product;
import com.thpffcj.entity.ProductCategory;
import com.thpffcj.entity.Shop;
import com.thpffcj.enums.ProductStateEnum;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Thpffcj on 2018/1/8.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductServiceTest extends BaseTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testAAddProduct() throws Exception {
        // 创建shopId为44且ProductCategoryId为1的商品实例并给其成员变量赋值
        Product product = new Product();
        Shop shop = new Shop();
        shop.setShopId(44L);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryId(1L);
        product.setShop(shop);
        product.setProductCategory(productCategory);
        product.setProductName("测试商品1");
        product.setProductDesc("测试商品1");
        product.setPriority(20);
        product.setCreateTime(new Date());
        product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
        // 创建缩略图文件里流
        File thumbnailFile = new File("E:/github.jpg");
        InputStream inputStream = new FileInputStream(thumbnailFile);
        ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(), inputStream);
        // 创建两个商品详情图文件流并将他们添加到详情图列表中
        File productImg1 = new File("E:/kennethreitz.jpg");
        InputStream is1 = new FileInputStream(productImg1);
        File productImg2 = new File("E:/鹿乃.jpg");
        InputStream is2 = new FileInputStream(productImg2);
        List<ImageHolder> productImgList = new ArrayList<>();
        productImgList.add(new ImageHolder(productImg1.getName(), is1));
        productImgList.add(new ImageHolder(productImg2.getName(), is2));
        // 添加商品并验证
        ProductExecution productExecution = productService.addProduct(product, thumbnail, productImgList);
        assertEquals(ProductStateEnum.SUCCESS.getState(), productExecution.getState());
    }
}