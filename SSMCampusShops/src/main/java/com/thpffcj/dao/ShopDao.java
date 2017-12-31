package com.thpffcj.dao;

import com.thpffcj.entity.Shop;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 分页查询店铺，可输入的条件有：店铺名(模糊)，店铺状态，店铺类别，区域Id，owner
     * @param shopCondition
     * @param rowIndex 从第几行开始取数据
     * @param pageSize 返回的条数
     * @return
     */
    List<Shop> queryShopList(@Param("shopCondition")Shop shopCondition,
                             @Param("rowIndex")int rowIndex,
                             @Param("pageSize")int pageSize);

    /**
     * 返回queryShopList总数
     * @param shopConditio
     * @return
     */
    int queryShopCount(@Param("shopCondition")Shop shopConditio);
}
