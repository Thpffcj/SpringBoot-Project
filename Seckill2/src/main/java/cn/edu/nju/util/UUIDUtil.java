package cn.edu.nju.util;

import java.util.UUID;

/**
 * Created by Thpffcj on 2018/1/23.
 */
public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
