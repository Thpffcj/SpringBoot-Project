package cn.edu.nju.access;

import cn.edu.nju.domain.User;

/**
 * Created by Thpffcj on 2018/1/26.
 */
public class UserContext {

    private static ThreadLocal<User> userHolder = new ThreadLocal<User>();

    public static void setUser(User user) {
        userHolder.set(user);
    }

    public static User getUser() {
        return userHolder.get();
    }

}
