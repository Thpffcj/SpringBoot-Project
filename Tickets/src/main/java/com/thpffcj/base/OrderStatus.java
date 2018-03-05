package com.thpffcj.base;

/**
 * Created by Thpffcj on 2018/3/2.
 */
public enum OrderStatus {

    NOT_AUDITED(0), // 未审核
    PASSES(1), // 审核通过
    RENTED(2), // 已出租
    DELETED(3); // 逻辑删除

    private int value;

    OrderStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
