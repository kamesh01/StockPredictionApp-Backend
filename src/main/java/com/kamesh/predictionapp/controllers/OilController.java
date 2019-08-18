package com.kamesh.predictionapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kamesh.predictionapp.models.Oil;

@RestController
public class OilController {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@CrossOrigin(origins = "http://localhost:4200")
//	Getting values from database and returning object to front end
	@RequestMapping("/oil/get")
	public Oil getOil(@RequestParam("oilName") String oilName)
	{
		Oil emptyOil = new Oil(oilName, "", "");
		List<Object> oilStock = jdbcTemplate.query("SELECT * FROM oil_table where oilName=?", new Object[] {oilName} , 
				(rs, rowNum) -> new Oil(rs.getString("oilName"), rs.getString("oilValues"), rs.getString("searchTime")));
		return oilStock.size()>0?(Oil) oilStock.get(0): emptyOil;
	}
}
