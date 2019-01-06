package com.xxl.domain;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @author sean
 * @date 2019/01/06/23:49
 **/
public class BaseDomain implements Serializable {

    private static final long serialVersionUID = -1073385822941357208L;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
