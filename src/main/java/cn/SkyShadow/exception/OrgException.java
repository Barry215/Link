package cn.SkyShadow.exception;

public class OrgException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7705749692258541187L;

	public OrgException(String message) {
		super(message);
	}

	public OrgException(String message, Throwable cause) {
		super(message, cause);
	}
}
