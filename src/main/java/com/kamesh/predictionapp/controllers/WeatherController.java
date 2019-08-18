package com.kamesh.predictionapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kamesh.predictionapp.models.Weather;


@RestController
public class WeatherController {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@CrossOrigin(origins = "http://localhost:4200")
	
// Getting values from database and returning object to front end
	@RequestMapping("/weather/get")
	public Weather getWeather(@RequestParam("cityName") String cityName)
	{
		Weather emptyCityWeather = new Weather(cityName, "" , "");		
		
		List<Object> cityWeathers = jdbcTemplate.query("SELECT * FROM weather_table where cityName=?", new Object[] {cityName} , 
				(rs, rowNum) -> new Weather(rs.getString("cityName"), rs.getString("weatherValues"), rs.getString("searchTime")));
		//jdbcTemplate.update("INSERT INTO weather_table(cityName, weatherValues, searchTime)VALUES(?,?,?)", new Object[] {"KOL","1,2,3,4",""});
		return cityWeathers.size()>0?(Weather) cityWeathers.get(0):emptyCityWeather;
	}
}
