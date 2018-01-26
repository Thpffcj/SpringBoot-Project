package cn.edu.nju.redis;

/**
 * Created by Thpffcj on 2018/1/26.
 */
public class SeckillKey extends BasePrefix {

    private SeckillKey( int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
    public static SeckillKey isGoodsOver = new SeckillKey(0, "go");
    public static SeckillKey getSeckillPath = new SeckillKey(60, "mp");
    public static SeckillKey getSeckillVerifyCode = new SeckillKey(300, "vc");
}
