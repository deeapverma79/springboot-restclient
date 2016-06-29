package com.springboot.weatherservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class WeatherServiceUtil  {

	private static final Logger log = LoggerFactory.getLogger(WeatherServiceUtil.class);

	public static boolean isError(int statusCode) {
		log.info("Status Code :" + statusCode);
		HttpStatus.Series series = HttpStatus.valueOf(statusCode).series();
        return (HttpStatus.Series.CLIENT_ERROR.equals(series)
                || HttpStatus.Series.SERVER_ERROR.equals(series));
	}
}
