package cn.SkyShadow.dto.exception;

/**
 * 操作权限的异常
 * Created by Richard on 16/9/19.
 */
public class OperaException extends RuntimeException {
    public OperaException(String message) {
        super(message);
    }
}
