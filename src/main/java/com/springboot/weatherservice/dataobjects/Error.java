package com.springboot.weatherservice.dataobjects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class maps the error from the weather website
 * @author Deepa
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Error {
	int cod;
	String message;
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
