package com.zhoujixing.shiro;

/**
 * 实现自己手动抛出异常
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String msg){
        super(msg);
    }
    public UnauthorizedException(){
        super();
    }
}
