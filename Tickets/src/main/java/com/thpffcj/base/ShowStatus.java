package com.thpffcj.base;

/**
 * Created by Thpffcj on 2018/3/12.
 */
public enum  ShowStatus {

    SETTLEMENT(0), // 未审核
    UNSETTLEMENT(1); // 审核通过

    private int value;

    ShowStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
