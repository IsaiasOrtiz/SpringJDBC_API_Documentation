package com.confetystudios.test.dto;

import org.springframework.http.HttpStatus;

public class GenericResponse {
	private HttpStatus code; 
	private String menssage;
	public HttpStatus getCode() {
		return code;
	}
	public void setCode(HttpStatus code) {
		this.code = code;
	}
	public String getMenssage() {
		return menssage;
	}
	public void setMenssage(String menssage) {
		this.menssage = menssage;
	}
	public GenericResponse(HttpStatus code, String menssage) {
		super();
		this.code = code;
		this.menssage = menssage;
	}
	
}
