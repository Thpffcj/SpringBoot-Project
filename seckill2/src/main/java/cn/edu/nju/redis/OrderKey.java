package cn.edu.nju.redis;

/**
 * Created by Thpffcj on 2018/1/22.
 */
public class OrderKey extends BasePrefix {

    public OrderKey(String prefix) {
        super(prefix);
    }

    public static OrderKey getSeckillOrderByUidGid = new OrderKey("moug");

}
