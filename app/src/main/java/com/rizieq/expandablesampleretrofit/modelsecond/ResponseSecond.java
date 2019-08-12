package com.rizieq.expandablesampleretrofit.modelsecond;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseSecond{

	@SerializedName("serve")
	private List<ServeItem> serve;

	@SerializedName("message")
	private String message;

	public ResponseSecond(List<ServeItem> serve, String message) {
		this.serve = serve;
		this.message = message;
	}

	public void setServe(List<ServeItem> serve){
		this.serve = serve;
	}

	public List<ServeItem> getServe(){
		return serve;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}