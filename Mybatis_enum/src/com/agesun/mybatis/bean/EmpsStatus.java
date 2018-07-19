package com.agesun.mybatis.bean;

/*
 * 
 * 保存数据库100，200，状态吗，不是默认的0，或者枚举名
 * */
public enum EmpsStatus {
	
	LOGIN(100,"用户登录"),LOGINOUT(200,"用户退出"),REMOVE(300,"用户不存在");
	
	private Integer code;
	private String msg;

	private EmpsStatus(Integer code,String msg) {
		this.code=code;
		this.msg=msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	//按照状态码返回枚举对象
	public static EmpsStatus getEmpStatusByCode(Integer code){
		switch (code) {
		case 100:
			return LOGIN;
		case 200:
			return LOGINOUT;
		case 300:
			return REMOVE;
		default:
			return LOGINOUT;
		}
	}
	
	
	public static EmpsStatus getEmpEnum(int code) {
		for(EmpsStatus sourceEnum:  EmpsStatus.values()) {
	    	if(sourceEnum.getCode() == code) return sourceEnum;
	    }
		return null;
	}
	
	
	
	
	
	

}
