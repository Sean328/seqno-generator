package com.xxl.exception;

/**
 * id生成异常
 *
 * @author lixin
 * @date 2019-01-09 10:36
 **/
public class IdGenerateException extends RuntimeException {
    private static final long serialVersionUID = -3089334438349678311L;

    public IdGenerateException() {
        super();
    }

    public IdGenerateException(String message) {
        super(message);
    }

    public IdGenerateException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdGenerateException(Throwable cause) {
        super(cause);
    }

    protected IdGenerateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
