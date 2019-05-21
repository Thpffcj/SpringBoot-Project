package cn.edu.nju.web.interceptor;

import cn.edu.nju.common.model.User;

/**
 * Created by Thpffcj on 2018/5/4.
 */
public class UserContext {

    private static final ThreadLocal<User> USER_HOLDER = new ThreadLocal<>();

    public static void setUser(User user) {
        USER_HOLDER.set(user);
    }

    public static void remove() {
        USER_HOLDER.remove();
    }

    public static User getUser() {
        return USER_HOLDER.get();
    }
}
