package cn.edu.nju.redis;

/**
 * Created by Thpffcj on 2018/1/22.
 */
public interface KeyPrefix {

    public int expireSeconds();

    public String getPrefix();
}
