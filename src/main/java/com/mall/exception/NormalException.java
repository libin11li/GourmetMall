package com.mall.exception;

/**
 * @author li
 * description:自定义业务异常
 * date: 2021/1/6
 */
public class NormalException extends RuntimeException {

    public NormalException(String message){
        super(message);
    }

}
