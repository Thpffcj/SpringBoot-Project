package cn.edu.nju.access;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Created by Thpffcj on 2018/1/26.
 */

@Retention(RUNTIME)
@Target(METHOD)
public @interface AccessLimit {

    int seconds();

    int maxCount();

    boolean needLogin() default true;
}
