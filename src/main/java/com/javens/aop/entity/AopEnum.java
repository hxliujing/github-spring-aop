package com.javens.aop.entity;

public enum AopEnum {
    SAVE(0),
    FIND(1),
    DELETE(2),
    ;
    private final int code;

    AopEnum(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}
