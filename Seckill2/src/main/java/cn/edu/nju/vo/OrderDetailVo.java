package cn.edu.nju.vo;

import cn.edu.nju.domain.OrderInfo;

/**
 * Created by Thpffcj on 2018/1/25.
 */
public class OrderDetailVo {

    private GoodsVo goods;
    private OrderInfo order;

    public GoodsVo getGoods() {
        return goods;
    }

    public void setGoods(GoodsVo goods) {
        this.goods = goods;
    }

    public OrderInfo getOrder() {
        return order;
    }

    public void setOrder(OrderInfo order) {
        this.order = order;
    }
}
