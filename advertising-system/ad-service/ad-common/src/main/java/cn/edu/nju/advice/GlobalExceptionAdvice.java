package cn.edu.nju.advice;

import cn.edu.nju.exception.AdException;
import cn.edu.nju.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by thpffcj on 2019/8/25.
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    // 只处理AdException一种异常
    @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> handlerAdException (HttpServletRequest request,
                                                      AdException ex) {
        CommonResponse<String> response = new CommonResponse<>(-1,
                "business error");
        response.setData(ex.getMessage());
        return response;
    }
}
