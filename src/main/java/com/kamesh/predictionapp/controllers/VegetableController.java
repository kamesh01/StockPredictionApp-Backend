package com.kamesh.predictionapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kamesh.predictionapp.models.Vegetables;
import com.kamesh.predictionapp.models.Weather;


@RestController
public class VegetableController {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@CrossOrigin(origins = "http://localhost:4200")
	// Getting values from database and returning object to front end
	@RequestMapping("/vegetables/get")
	public Vegetables getVege(@RequestParam("vegeName") String vegeName)
	{
		Vegetables emptyVege = new Vegetables(vegeName, "" , "");		
		
		List<Object> vegeStock = jdbcTemplate.query("SELECT * FROM vegetables_table where vegeName=?", new Object[] {vegeName} , 
				(rs, rowNum) -> new Weather(rs.getString("vegeName"), rs.getString("vegeValues"), rs.getString("searchTime")));
		return vegeStock.size()>0?(Vegetables) vegeStock.get(0):emptyVege;
	}
}
