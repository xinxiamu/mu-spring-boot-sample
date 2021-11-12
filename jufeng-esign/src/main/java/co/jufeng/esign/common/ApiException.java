package co.jufeng.esign.common;

import org.springframework.util.Assert;

/**
 *  API错误消息。内部服务统一异常
 */
public class ApiException extends RuntimeException {

	private int code;

	private String message;

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public ApiException(int code, String message, Throwable throwable) {
		super(ApiException.class.getCanonicalName().concat(":").concat(String.valueOf(code)).concat(":")
				.concat(message), throwable);
		Assert.notNull(message, "The ApiException's message should not be null");
		this.code = code;
		this.message = message;
	}
}
