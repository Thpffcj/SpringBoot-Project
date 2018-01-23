package cn.edu.nju.exception;

import cn.edu.nju.result.CodeMsg;

/**
 * Created by Thpffcj on 2018/1/23.
 */
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg) {
        super(codeMsg.toString());
        this.codeMsg = codeMsg;
    }

    public CodeMsg getCm() {
        return codeMsg;
    }
}
