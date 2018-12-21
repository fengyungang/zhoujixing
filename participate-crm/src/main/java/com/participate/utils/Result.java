package com.participate.utils;

import lombok.Data;

/**
 * 自定义返回信息类
 */

@Data
public class Result {

    /**
     * 状态值，0表示成功，其他值表示各种异常
     */
    private Integer code;
    /**
     * 信息描述
     */
    private String msg;
    /**
     * 返回的数据
     */
    private Object res;

    public Result(Integer code, String msg, Object res) {
        this.code = code;
        this.msg = msg;
        this.res = res;
    }

    public Result() {
    }
    //返回类生成方法
    public static Result generate(Integer code, String msg, Object res){
        Result result = new Result(code,msg,res);
        return result;
    }

}
