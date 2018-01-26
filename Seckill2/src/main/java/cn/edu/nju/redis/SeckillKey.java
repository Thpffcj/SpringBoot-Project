package cn.edu.nju.redis;

/**
 * Created by Thpffcj on 2018/1/26.
 */
public class SeckillKey extends BasePrefix {

    private SeckillKey(String prefix) {
        super(prefix);
    }

    public static SeckillKey isGoodsOver = new SeckillKey("go");
}
