package com.mall.vo.response;

import lombok.Data;

@Data
public class R<T>{

    private int code;

    private String msg;

    private T data;

    /**
     * 构造方法私有化
     */
    private R(){}

    @Data
    public static class Builder{

        private int code;

        private String msg;

        private Object data;

        private Builder(){}

        public Builder success(int code){
            this.code = code;
            return this;
        }

        public Builder error(int code){
            this.code = code;
            return this;
        }

        public Builder data(Object data){
            this.data = data;
            return this;
        }

        public Builder msg(String msg){
            this.msg = msg;
            return this;
        }

    }

    public static Builder builder()

}
