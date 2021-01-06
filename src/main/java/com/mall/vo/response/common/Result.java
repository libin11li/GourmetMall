package com.mall.vo.response.common;

import com.mall.enums.common.ResultStatus;
import lombok.Data;

/**
 * @author: li
 * description:统一返回值
 * date: 2021/1/5
 */
@Data
public class Result<T>{

    private String code;

    private String msg;

    private T data;

    /**
     * 构造方法私有化
     */
    private Result(Builder<T> builder){
        this.code = builder.getCode();
        this.msg = builder.getMsg();
        this.data = builder.getData();
    }

    @Data
    public static class Builder<T>{

        private String code;

        private String msg;

        private T data;

        private Builder(){}

        public Builder<T> success(){
            this.code = ResultStatus.SUCCESS.getCode();
            this.msg = ResultStatus.SUCCESS.getMsg();
            return this;
        }

        public Builder<T> error(String code){
            this.code = code;
            return this;
        }

        public Builder<T> error(ResultStatus resultStatus){
            this.code = resultStatus.getCode();
            this.msg = resultStatus.getMsg();
            return this;
        }

        public Builder<T> data(T data){
            this.data = data;
            return this;
        }

        public Builder<T> msg(String msg){
            this.msg = msg;
            return this;
        }

        public Result<T> build(){
            return new Result<>(this);
        }

    }

    public static <T> Result.Builder<T> builder(){
        return new Result.Builder<>();
    }

}
