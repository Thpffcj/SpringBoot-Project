package cn.edu.nju.item.service;

import cn.edu.nju.item.pojo.Items;

/**
 * Created by Thpffcj on 2018/4/29.
 */
public interface ItemsService {

    /**
     * @Description: 根据商品id获取商品
     */
    public Items getItem(String itemId);

    /**
     * @Description: 查询商品库存
     */
    public int getItemCounts(String itemId);

    /**
     * @Description: 购买商品成功后减少库存
     */
    public void displayReduceCounts(String itemId, int buyCounts);

}
