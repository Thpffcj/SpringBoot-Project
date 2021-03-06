package cn.edu.nju.security;

/**
 * 用 ThreadLocal 去单独存储每一个线程携带的 Token 信息
 * Created by thpffcj on 2019-04-18.
 */
public class AccessContext {

    private static final ThreadLocal<String> token = new ThreadLocal<String>();

    public static String getToken() {
        return token.get();
    }

    public static void setToken(String tokenStr) {
        token.set(tokenStr);
    }

    public static void clearAccessKey() {
        token.remove();
    }
}
