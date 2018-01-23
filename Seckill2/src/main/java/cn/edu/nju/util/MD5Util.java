package cn.edu.nju.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by Thpffcj on 2018/1/22.
 */
public class MD5Util {

    private static final String salt = "1a2b3c4d";

    private static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    private static String inputPassFromPass(String inputPass) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String fromPassToDBPass(String formPass, String salt) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String inputPassToDBPass(String input, String saltDB) {
        return fromPassToDBPass(inputPassFromPass(input), saltDB);
    }

    public static void main(String[] args) {
        System.out.println(inputPassFromPass("123456"));
        System.out.println(fromPassToDBPass(inputPassFromPass("123456"), "1a2b3c4d"));
    }
}
