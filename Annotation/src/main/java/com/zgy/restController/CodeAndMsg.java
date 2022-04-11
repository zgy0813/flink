package com.zgy.restController;

public enum CodeAndMsg {
    SUCCESS(1000, "SUCCESS"),
    METHOD_FAIL(2000, "ENCOUNTER AN ERROR WHEN EXECUTE METHOD"),
    UNKNOWN_EXCEPTION(3000, "THIS IS AN UNKNOWN EXCEPTION");

    private int code;
    private String msg;

    CodeAndMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
