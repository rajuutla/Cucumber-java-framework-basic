package com.test.common.framework;

public class ReturnValue {
	private boolean methodResult;
	public boolean isMethodResult() {
		return methodResult;
	}
	public void setMethodResult(boolean methodResult) {
		this.methodResult = methodResult;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String message;
	
	ReturnValue(boolean methodResult, String message){
		this.methodResult = methodResult;
		this.message = message;
	}

}
