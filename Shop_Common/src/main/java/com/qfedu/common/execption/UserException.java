package com.qfedu.common.execption;

/**
 *  用户注册异常类
 */
public class UserException extends Exception {

    public UserException(){

    }

    public UserException(String msg){
        super(msg);
    }
}
