package com.thpffcj.base;

/**
 * Created by Thpffcj on 2018/1/30.
 */
public enum  VenueStatus {

    NOT_AUDITED(0), // 未审核
    PASSES(1), // 审核通过
    MODIFY(2), // 申请修改
    DELETED(3); // 逻辑删除
    private int value;

    VenueStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
