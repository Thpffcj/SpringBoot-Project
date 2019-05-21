package cn.edu.nju.common.utils;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

/**
 * Created by Thpffcj on 2018/5/2.
 */
public class HashUtils {

    private static final HashFunction FUNCTION = Hashing.md5();

    private static final String SALT = "thpffcj.com";

    public static String encryPassword(String password) {
        HashCode hashCode = FUNCTION.hashString(password + SALT, Charset.forName("UTF-8"));
        return hashCode.toString();
    }
}
