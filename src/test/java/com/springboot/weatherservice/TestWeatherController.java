package com.springboot.weatherservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class TestWeatherController {

	private final MockMvc mvc = MockMvcBuilders.standaloneSetup(new WeatherServiceController()).build();
	
	@Test
	public void validateRetrieve() throws Exception {
		mvc.perform(get("/")).andExpect(status().isOk())
	     .andExpect(forwardedUrl("form"));
	}
}
