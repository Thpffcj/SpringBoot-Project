package cn.edu.nju.item.service.impl;

import cn.edu.nju.item.mapper.ItemsMapper;
import cn.edu.nju.item.pojo.Items;
import cn.edu.nju.item.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Thpffcj on 2018/4/29.
 */
@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public Items getItem(String itemId) {
        return itemsMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public int getItemCounts(String itemId) {
        Items item = itemsMapper.selectByPrimaryKey(itemId);
        return item.getCounts();
    }

    @Override
    public void displayReduceCounts(String itemId, int buyCounts) {
        Items reduceItem = new Items();
        reduceItem.setId(itemId);
        reduceItem.setBuyCounts(buyCounts);
        itemsMapper.reduceCounts(reduceItem);
    }
}
