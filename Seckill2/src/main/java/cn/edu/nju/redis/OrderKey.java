package cn.edu.nju.redis;

/**
 * Created by Thpffcj on 2018/1/22.
 */
public class OrderKey extends BasePrefix {

    public OrderKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

}
