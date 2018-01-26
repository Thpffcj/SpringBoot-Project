package cn.edu.nju.redis;

/**
 * Created by Thpffcj on 2018/1/26.
 */
public class AccessKey extends BasePrefix{

    private AccessKey( int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static AccessKey withExpire(int expireSeconds) {
        return new AccessKey(expireSeconds, "access");
    }
}
