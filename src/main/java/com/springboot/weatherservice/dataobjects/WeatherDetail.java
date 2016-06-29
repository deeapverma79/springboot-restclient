package com.springboot.weatherservice.dataobjects;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.springboot.weatherservice.UnixTimestampDeserializer;

/**
 * Maps the 'sys' attribute from weather website JSON object.
 * @author Deepa
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDetail {
	int type;
	int id;
	Double message;
	String country;
	@JsonDeserialize(using = UnixTimestampDeserializer.class)
	private Date sunrise; 
	@JsonDeserialize(using = UnixTimestampDeserializer.class)
	private Date sunset;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getMessage() {
		return message;
	}
	public void setMessage(Double message) {
		this.message = message;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getSunrise() {
		return sunrise;
	}
	public void setSunrise(Date sunrise) {
		this.sunrise = sunrise;
	}
	public Date getSunset() {
		return sunset;
	}
	public void setSunset(Date sunset) {
		this.sunset = sunset;
	}
}
