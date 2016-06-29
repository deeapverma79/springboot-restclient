package com.springboot.weatherservice.dataobjects;

import java.util.Date;
import java.util.Map;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.springboot.weatherservice.UnixTimestampDeserializer;

/**
 * This class is the deserialised representation of the data recieved from openweathermap.org
 * @author Deepa
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {
	
	@JsonProperty(value="coord")
	Map<String, String> coordinates;  
	SkyCondition skyCondition;
	Headline main; 
	@JsonDeserialize(using = UnixTimestampDeserializer.class)
	@JsonProperty(value="dt")
	private Date date;  
	@JsonProperty(value="sys")
	WeatherDetail weatherDetails; 
	String id;  
	@NotNull
	String name; 
	@JsonIgnore
	Map<String, String> wind;  
	@JsonIgnore
	Map<String, String> clouds; 
	@JsonIgnore
	String base; 
	@JsonIgnore
	String cod;   
	 

	public WeatherData() { 
	}

	public Map<String, String> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Map<String, String> coordinates) {
		this.coordinates = coordinates;
	}

	public SkyCondition getSkyCondition() {
		return skyCondition;
	}

	public void setSkyCondition(SkyCondition skyCondition) {
		this.skyCondition = skyCondition;
	}

	public Headline getMain() {
		return main;
	}

	public void setMain(Headline main) {
		this.main = main;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public WeatherDetail getWeatherDetails() {
		return weatherDetails;
	}

	public void setWeatherDetails(WeatherDetail weatherDetails) {
		this.weatherDetails = weatherDetails;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}