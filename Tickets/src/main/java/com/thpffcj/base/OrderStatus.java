package com.thpffcj.base;

/**
 * Created by Thpffcj on 2018/3/2.
 */
public enum OrderStatus {

    BOOK(0), // 已预定
    CHECK (1), // 已检票
    REFUND(2); // 已退票

    private int value;

    OrderStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
