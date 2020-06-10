package com.tututu.qa.common.exception;

/**
 * @author 玉麒麟
 * @Description printable exception
 * @createTime 2020年05月16日 14:30:00
 */
public abstract class PrintableException extends RuntimeException {
    public PrintableException() {
    }

    public PrintableException(String message) {
        super(message);
    }

    public PrintableException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrintableException(Throwable cause) {
        super(cause);
    }

    public PrintableException(String message, Throwable cause, boolean enableSuppression,
                              boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
