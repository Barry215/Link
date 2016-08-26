package cn.SkyShadow.exception;

public class UserNotLoginException extends RuntimeException {
	/**
	 * 用户信息验证不通过
	 */
	private static final long serialVersionUID = 9071954184353086634L;

	public UserNotLoginException(String message) {
		super(message);
	}

	public UserNotLoginException(String message, Throwable cause) {
		super(message, cause);
	}
}
