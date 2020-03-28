package com.ty.springbootdemo.message;

import lombok.Data;

@Data
public class CodeMsg {
    private int code;
    private String msg;
    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CodeMsg fillArgs(Object... args) {//带自定义格式化参数的错误信息
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code,message);
    }

    /**
     * 通用异常
     */
    public static CodeMsg FAIL = new CodeMsg(500, "SUCESS");
    /**
     * 注册模块501XX
     */
    public static final CodeMsg PASSWORD_EMPTY = new CodeMsg(50101, "密码不能为空");
    public static final CodeMsg USER_NOT_EXITS = new CodeMsg(50102, "用户不存在");
    public static final CodeMsg PASSWORD_ERROR = new CodeMsg(50103, "密码错误");
}
