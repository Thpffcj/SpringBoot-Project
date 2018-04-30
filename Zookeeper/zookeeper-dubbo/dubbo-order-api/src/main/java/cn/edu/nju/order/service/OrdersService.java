package cn.edu.nju.order.service;

import cn.edu.nju.order.pojo.Orders;

/**
 * Created by Thpffcj on 2018/4/30.
 */
public interface OrdersService {

    /**
     * @Description: 根据订单id查询订单
     */
    public Orders getOrder(String orderId);

    /**
     * @Description: 下订单
     */
    public boolean createOrder(String itemId);

}
