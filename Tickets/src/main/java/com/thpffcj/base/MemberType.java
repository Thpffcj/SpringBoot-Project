package com.thpffcj.base;

/**
 * Created by Thpffcj on 2018/3/12.
 */
public enum MemberType {

    USER(0),            // 普通用户
    VENUE_MANAGER(2),   // 逻辑删除
    SYSTEM_MANAGER(3);  // 系统管理员

    private int value;

    MemberType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
