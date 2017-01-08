package com.wuhulala.loginsystem.dto;



public enum ReturnCode {

	SUCCESS("0", "成功"),
	error("-1", "系统繁忙"),

	//登录信息
	LOGIN_SUCCESS("1001","登录成功"),
	LOGIN_ERROR("1002","用户名或密码错误"),
	LOGIN_NAME_IS_NOT_EXIST("1003","用户名不存在"),
	LOGIN_PASSWORD_IS_ERROR("1004","密码错误"),

	//注册信息
	REGISTER_SUCCESS("1101","注册成功"),
	REGISTER_ERROR("1102","注册失败"),
	REGISTER_NAME_IS_EXIST("1103","用户名已存在"),

	//修改密码
	EDIT_PASS_SUCCESS("1201","修改密码成功"),
	EDIT_PASS_ERROR("1202","修改密码错误"),
	EDIT_PASS_PASSWORD_IS_ERROR("1203","原密码错误"),

	USER_IS_NOT_LOGIN("1301","用户没有此订单的权限");
	public static ReturnCode getReturnCode(String returnCode){
		for( ReturnCode e : ReturnCode.values() ){
			if( e.getResultCode().equals(returnCode)){
				return e ;
			}
		}
		return null ;
	}
	
	ReturnCode(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    private String resultCode;

    private String resultMsg;

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
    
    
}
