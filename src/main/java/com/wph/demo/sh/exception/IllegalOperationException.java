package com.wph.demo.sh.exception;

/**
 * @Description :
 * @Author :wangcheng
 * @Date :2020/4/25 17:34
 */
public class IllegalOperationException extends RuntimeException{

    public IllegalOperationException() {
        super();
    }

    public IllegalOperationException(String message) {
        super(message);
    }

    public IllegalOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalOperationException(Throwable cause) {
        super(cause);
    }

    protected IllegalOperationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
