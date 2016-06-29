package com.springboot.weatherservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.springboot.weatherservice.dataobjects.WeatherData;

/**
 * Main controller class which receives the request from form.html. This
 * provides a GET & POST API.
 */

@Controller
@EnableAutoConfiguration
public class WeatherServiceController {

	private static final String APPID = "&appid=f1ff95dc5facdb3c606ead18732cf718";
	private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
	private static final Logger log = LoggerFactory.getLogger(WeatherServiceController.class);

	/**
	 * Get is used to display the main page form.html which is a thymeleaf
	 * template.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	String home(Model model) {
		WeatherDataDecorator weatherDisplay = new WeatherDataDecorator();
		model.addAttribute("weatherDisplay", weatherDisplay);
		return "form";
	}

	/**
	 * Post is used to Post the form.html to the server with the user selection.
	 * The method acts as a client and uses RestTemplate to retrieve the weather
	 * data from openweathermap.org
	 * 
	 * @param model
	 * @param weatherDisplay
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String checkInfo(Model model, WeatherDataDecorator weatherDisplay, BindingResult bindingResult) {
		String name = weatherDisplay.getName();
		log.info("Received a request for retreiving weather for : " + name);
		RestTemplate restTemplate = new RestTemplate();
		WeatherData weatherData = restTemplate.getForObject(BASE_URL + name + APPID, WeatherData.class);
		if (!WeatherServiceUtil.isError(weatherData.getCod())) {
			weatherDisplay = new WeatherDataDecorator(weatherData);
			model.addAttribute("weatherDisplay", weatherDisplay);
		} else {
			ServiceError error = new ServiceError(weatherData.getCod(), weatherData.getMessage());
			model.addAttribute("weatherDisplay", weatherDisplay);
			model.addAttribute("error", error);
		}
		return "form";
	}

	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {
		ex.printStackTrace();
		return "error";
	}
}