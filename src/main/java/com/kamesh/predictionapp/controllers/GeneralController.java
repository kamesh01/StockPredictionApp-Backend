package com.kamesh.predictionapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kamesh.predictionapp.models.General;

@RestController
public class GeneralController {
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@CrossOrigin(origins = "http://localhost:4200")
//	Getting values from database and returning object to front end
	@RequestMapping("/general/get")
	public General getGeneral(@RequestParam("companyName") String compName)
	{
		General emptyGeneral = new General(compName, "" , "");
		
		List<Object> generalStock = jdbcTemplate.query("SELECT * FROM general_table where generalName=?", new Object[] {compName} , 
				(rs, rowNum) -> new General(rs.getString("generalName"), rs.getString("generalValues"), rs.getString("searchTime")));
		return generalStock.size()>0?(General) generalStock.get(0):emptyGeneral;
	}
}
