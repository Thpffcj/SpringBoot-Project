package com.thpffcj.util;

import java.util.UUID;

/**
 * Created by Thpffcj on 2018/3/20.
 */
public class CodeUtil {

    // 生成唯一的激活码
    public static String generateUniqueCode(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
