package com.springboot.weatherservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class TestWeatherController {

	private final MockMvc mvc = MockMvcBuilders.standaloneSetup(new WeatherServiceController()).build();
	
	@Test
	public void validateGet() throws Exception {
		mvc.perform(get("/")).andExpect(status().isOk())
	     .andExpect(forwardedUrl("form"));
	 
	}
	
	@Test
	public void validatePostPass() throws Exception {
		mvc.perform(post("/").param("name", "London"))
		   .andExpect(status().isOk())
		   .andExpect(model().attributeExists("weatherDisplay"))
		   .andExpect(model().attributeDoesNotExist("error"));
	}
	
	@Test
	public void validatePostFail() throws Exception {
		mvc.perform(post("/").param("name", "thisdoenstexist123456789"))
		   .andExpect(status().isOk())
		   .andExpect(model().attributeExists("weatherDisplay"))
		   .andExpect(model().attributeExists("error"));
	}
}
