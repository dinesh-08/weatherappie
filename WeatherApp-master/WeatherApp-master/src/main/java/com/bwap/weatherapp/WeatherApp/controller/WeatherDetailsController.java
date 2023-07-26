package com.bwap.weatherapp.WeatherApp.controller;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bwap.weatherapp.WeatherApp.Repository.WeatherDetailsRepository;
import com.bwap.weatherapp.WeatherApp.Service.WeatherService;
import com.bwap.weatherapp.WeatherApp.model.WeatherDetails;

@RestController
public class WeatherDetailsController {
	
	@Autowired
	private WeatherService weatherservice;
	
	@Autowired
	private WeatherDetailsRepository weatherRepo;
	
	@PostMapping("/weatherDetails")
	public void addWeatherDetailsDB(@RequestBody WeatherDetails wd) {
		try {
			System.out.println(weatherservice.returnMainObject().getInt("temp_max"));
			System.out.println(weatherservice.returnMainObject().getInt("humidity"));
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			wd.setTemp_max(weatherservice.returnMainObject().getInt("temp_max"));
			wd.setTemp_min(weatherservice.returnMainObject().getInt("temp_min"));
			wd.setPressure(weatherservice.returnMainObject().getInt("pressure"));
			wd.setHumidity(weatherservice.returnMainObject().getInt("humidity"));
			wd.setSpeed(weatherservice.returnMainObject().getInt("speed"));
			wd.setFeels_like(weatherservice.returnMainObject().getDouble("feels_like"));
			
			weatherRepo.save(wd);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
