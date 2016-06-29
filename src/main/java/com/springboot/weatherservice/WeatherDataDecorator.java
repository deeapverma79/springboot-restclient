package com.springboot.weatherservice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.springboot.weatherservice.dataobjects.WeatherData;

/**
 * This class has the responsibility to convert the data from API to format used to display to the user in form.html
 * 
 * @author Deepa
 *
 */
public class WeatherDataDecorator {

	// today’s date
	private Date date;
	// the city name
	private String name;
	// overall description of the weather (e.g. "Light rain", "Clear sky", etc.)
	private String description = "";
	// temperature in Fahrenheit and Celsius
	private String tempInF = "";
	private String tempInC = "";
	// sunrise and sunset times in 12 hour format (e.g. 9:35am; 11:47pm)
	private String sunrise = "";
	private String sunset = "";

	public WeatherDataDecorator() {
	}

	public WeatherDataDecorator(WeatherData weatherData) {
		date = weatherData.getDate();
		name = weatherData.getName();
		//TODO : SkyCondition is not getting populated its a list
		//description = weatherData.getSkyCondition().getDescription();
		Double temp = weatherData.getMain().getTemp();
		tempInF = String.valueOf(convertToF(temp));
		tempInC = String.valueOf(convertToC(temp));
		SimpleDateFormat _12HourSDF = new SimpleDateFormat("EEE, MMM d, ''yy hh:mm a");
		sunrise =   _12HourSDF.format(weatherData.getWeatherDetails().getSunrise());  
		sunset = _12HourSDF.format(weatherData.getWeatherDetails().getSunset()); 
	}

	private double convertToC(Double temp) {
		int d =(int) ((temp - 273.15)*100);
		double i = d/100.0;
		return i;
	}

	private double convertToF(Double temp) {
		int d =(int) ((temp * 9/5 - 459.67)*100);
		double i = d/100.0;
		return i;
	}

	public String getSunrise() {
		return sunrise;
	}

	public String getSunset() {
		return sunset;
	}

	public Date getDate() {
		return date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public String getTempInF() {
		return tempInF;
	}

	public String getTempInC() {
		return tempInC;
	}
}
