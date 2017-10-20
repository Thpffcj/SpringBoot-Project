package cn.edu.nju.exception;

import cn.edu.nju.enums.ResultEnum;

/**
 * Created by Thpffcj on 2017/10/20.
 */
public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
