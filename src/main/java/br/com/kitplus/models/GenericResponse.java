package br.com.kitplus.models;

import lombok.Getter;
import lombok.Setter;


public class GenericResponse <T> {
    @SuppressWarnings("unused")
	private int code;
    @SuppressWarnings("unused")
	private T body;
    
    
    public void setCode(int code) {    	
    	this.code = code;
    }
    
    public void setBody( T body) {
    	this.body = body;
    }
    
    public T getBody() {
    	return this.body;
    }    
    public int getCode() {
    	return this.code;
    }   
}
