package cn.SkyShadow.dto;

/**用于包装JSON的结果
 *
 */
public class JsonResult<T> {
	/**
	 * 是否出现错误，如出现，返回false，否则返回true
	 */
	private boolean success;
	/**
	 * 返回的数据
	 */
	private T data;
	/**
	 * 返回的错误，若出现错误，返回错误信息，否则为空
	 */
	private String err;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErr() {
		return err;
	}

	public void setErr(String err) {
		this.err = err;
	}

	public JsonResult(boolean success, T data, String err) {
		super();
		this.success = success;
		this.data = data;
		this.err = err;
	}

	public JsonResult(boolean success, String err) {
		super();
		this.success = success;
		this.err = err;
	}

	@Override
	public String toString() {
		return "JsonResult{" +
				"success=" + success +
				", data=" + data +
				", err='" + err + '\'' +
				'}';
	}
}
