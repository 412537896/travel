package com.weiminw.business;

public enum IllegalArgumentExceptionEnum {
	ID_INVALID("ID�������0");
	
	private String message;

	IllegalArgumentExceptionEnum(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
}
