package com.xxl.domain;

public enum IdMetaTypeEnum {

    SECONDS("seconds","秒级"),
    MILLIS("millis", "毫秒级");

    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    IdMetaTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
