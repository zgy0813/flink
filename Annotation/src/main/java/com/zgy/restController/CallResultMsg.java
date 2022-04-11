package com.zgy.restController;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CallResultMsg<T> {
    private boolean result;
    private int code;
    private String message;
    private T data;

    public CallResultMsg(boolean result, CodeAndMsg codeAndMsg, T t) {
        this.result = result;
        this.code = codeAndMsg.getCode();
        this.message = codeAndMsg.getMsg();
        this.data = t;
    }
}
