package com.springboot.weatherservice.dataobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Maps the 'main' attribute from weather website JSON object.
 * @author Deepa
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Headline {
	Double temp;
	String pressure;
	String humidity;
	@JsonProperty(value="temp_min")
	Double tempMin;
	@JsonProperty(value="temp_max")
	Double tempMax;
	
	public Double getTemp() {
		return temp;
	}
	public void setTemp(Double temp) {
		this.temp = temp;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public Double getTempMin() {
		return tempMin;
	}
	public void setTempMin(Double tempMin) {
		this.tempMin = tempMin;
	}
	public Double getTempMax() {
		return tempMax;
	}
	public void setTempMax(Double tempMax) {
		this.tempMax = tempMax;
	}
}
