package cn.edu.nju.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by thpffcj on 2019/8/26.
 */
public class CommonUtils {

    public static String md5(String value) {

        return DigestUtils.md5Hex(value).toUpperCase();
    }
}
