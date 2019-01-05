package com.xxl.snowflake;

/**
 * @author lixin
 * @date 2019-01-03 11:50
 **/
public class SeqNoGenerateException extends RuntimeException {
    public SeqNoGenerateException() {
        super();
    }

    public SeqNoGenerateException(String message) {
        super(message);
    }

    public SeqNoGenerateException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeqNoGenerateException(Throwable cause) {
        super(cause);
    }

    protected SeqNoGenerateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
