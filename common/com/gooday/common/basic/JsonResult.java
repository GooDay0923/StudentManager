package com.gooday.common.basic;

public class JsonResult {

	public static final String OP_SUCCESS = "1";

	public static final String OP_ERROR = "-1";
	
	private String code;
	
	private Object data;
	
	private String message;
	
    public JsonResult(){}

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	public static JsonResult success(Object data, String message){
		JsonResult jsonResult = new JsonResult();
		jsonResult.setCode(OP_SUCCESS);
		jsonResult.setData(data);
		jsonResult.setMessage(message);

		return jsonResult;
	}

	public static JsonResult error(String message){
		JsonResult jsonResult = new JsonResult();
		jsonResult.setCode(OP_ERROR);
		jsonResult.setMessage(message);

		return jsonResult;
	}
    
}
