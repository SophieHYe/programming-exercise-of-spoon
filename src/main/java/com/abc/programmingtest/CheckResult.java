package com.abc.programmingtest;

public class CheckResult<T> {

	private WarningLevel warning;
	private String message = "";
	private T data;


	public WarningLevel getWarning() {
		return warning;
	}

	public void setWarning(WarningLevel warning) {
		this.warning = warning;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public CheckResult(WarningLevel warning, String message, T data) {
		this.warning = warning;
		this.message = message;
		this.data = data;
	}

	public CheckResult(WarningLevel warning, String message) {
		this.warning = warning;
		this.message = message;

	}
	
	public CheckResult() {
	}

	
	
	
}
