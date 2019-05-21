package com.thpffcj.base;

/**
 * Created by Thpffcj on 2018/3/6.
 */
public enum MemberStatus {

    NORMAL(0), // 正常状态
    TO_BE_VERIFIED(1), // 正常状态
    DELETED(2); // 逻辑删除

    private int value;

    MemberStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
