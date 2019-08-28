package cn.edu.nju.constant;

import lombok.Getter;

/**
 * Created by thpffcj on 2019/8/26.
 */
@Getter
public enum CommonStatus {

    VALID(1, "有效状态"),
    INVALID(2, "无效状态");

    private Integer status;
    private String desc;

    CommonStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
