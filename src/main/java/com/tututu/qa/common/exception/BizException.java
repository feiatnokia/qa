package com.tututu.qa.common.exception;

/**
 * @author 玉麒麟
 * @description biz exception
 * @createTime 2020年05月16日 14:27:00
 */
public class BizException extends PrintableException{
    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }
}
