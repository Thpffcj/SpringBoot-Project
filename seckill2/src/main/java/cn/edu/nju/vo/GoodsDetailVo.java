package cn.edu.nju.vo;

import cn.edu.nju.domain.User;

/**
 * Created by Thpffcj on 2018/1/25.
 */
public class GoodsDetailVo {

    private int seckillStatus = 0;
    private int remainSeconds = 0;
    private GoodsVo goods;
    private User user;

    public int getSeckillStatus() {
        return seckillStatus;
    }

    public void setSeckillStatus(int seckillStatus) {
        this.seckillStatus = seckillStatus;
    }

    public int getRemainSeconds() {
        return remainSeconds;
    }

    public void setRemainSeconds(int remainSeconds) {
        this.remainSeconds = remainSeconds;
    }

    public GoodsVo getGoods() {
        return goods;
    }

    public void setGoods(GoodsVo goods) {
        this.goods = goods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
