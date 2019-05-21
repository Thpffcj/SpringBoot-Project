package cn.edu.nju.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用的相应对象
 * Created by thpffcj on 2019-04-18.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    // 错误码，正确返回 0
    private Integer errorCode = 0;

    // 错误信息，正确返回空字符串
    private String errorMsg = "";

    // 返回值对行啊
    private Object data;

    /**
     * 正确的响应构造函数
     *
     * @param data 返回值对象
     */
    public Response(Object data) {
        this.data = data;
    }
}
