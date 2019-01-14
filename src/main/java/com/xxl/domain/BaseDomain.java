package com.xxl.domain;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @author lixin
 * @date 2019-01-04 14:38
 **/
public class BaseDomain implements Serializable {

    private static final long serialVersionUID = -1073385822941357208L;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
