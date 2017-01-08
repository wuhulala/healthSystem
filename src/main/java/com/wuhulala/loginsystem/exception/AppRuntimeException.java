/**
 * 
 */
package com.wuhulala.loginsystem.exception;


import com.wuhulala.loginsystem.dto.ReturnCode;

/**
 * 应用异常基类，应用中其他异常都应继承该异常，该异常为非检查性异常
 * @author xueaohui
 * @date 2012-10-30
 */
@SuppressWarnings("serial")
public class AppRuntimeException extends RuntimeException {
	
	private ReturnCode returnCode;

	public AppRuntimeException() {
		super();
	}

	public AppRuntimeException(Throwable cause, ReturnCode returnCode) {
		super(returnCode.getResultMsg(), cause);
		this.returnCode = returnCode;
	}

	public AppRuntimeException(ReturnCode returnCode) {
		super(returnCode.getResultMsg());
		this.returnCode = returnCode;
	}

	public ReturnCode getReturnCode() {
		return returnCode;
	}

}
