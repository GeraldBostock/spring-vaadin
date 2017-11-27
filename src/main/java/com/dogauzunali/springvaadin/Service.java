package com.dogauzunali.springvaadin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import weatherapi.Weather;

@Test
@Component
public class Service {
	
	RestTemplate restTemplate;
	Weather weather;
	public List<List<Weather>> listOLists = new ArrayList<List<Weather>>();
	public List<Weather> weatherList = new ArrayList<Weather>();
	
	public List<Weather> getWeather(String city){
		
		Weather[] weatherArray = new Weather[2];
		
		restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
    	restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

    	try{
    		weather = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&APPID=d71bf9828a75d362d858d04df4c6e1e6", Weather.class);
    		weatherList.add(weather);
    	}catch(HttpClientErrorException e){
    		weather = null;
    		e.printStackTrace();
    	}
    	
    	return weatherList;
	}
	
	public Weather getWeather(){
		return this.weather;
	}
}
