package com.mall.config;

import com.mall.exception.NormalException;
import com.mall.vo.response.common.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author li
 * description:统一异常捕获器
 * date: 2021/1/6
 */
@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result<String> jsonParseError(HttpServletRequest request) {
        return Result.<String>builder().error(getStatus(request).value()).msg("JSON格式错误，无法解析对象").build();
    }

    /**
     * 自定义业务异常
     */
    @ExceptionHandler(NormalException.class)
    public Result<String> normalError(HttpServletRequest request, Throwable ex) {
        return Result.<String>builder().error(getStatus(request).value()).msg(ex.getMessage()).build();
    }

    @ExceptionHandler(Exception.class)
    public Result<String> allExceptionError(HttpServletRequest request, Throwable ex) {
        ex.printStackTrace();
        return Result.<String>builder().error(getStatus(request).value()).msg(ex.getMessage()).build();
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}
