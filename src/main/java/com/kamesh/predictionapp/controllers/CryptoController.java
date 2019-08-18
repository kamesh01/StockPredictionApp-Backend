package com.kamesh.predictionapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kamesh.predictionapp.models.Crypto;

@RestController
public class CryptoController {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@CrossOrigin(origins = "http://localhost:4200")
//	Getting values from database and returning object to front end
	@RequestMapping("/crypto/get")
	public Crypto getCryptocurrency(@RequestParam("currencyName") String currencyName)
	{
		Crypto emptyCrypto = new Crypto(currencyName, "" , "");
		
		List<Object> cryptoStock = jdbcTemplate.query("SELECT * FROM crypto_table where currencyName=?", new Object[] {currencyName} , 
				(rs, rowNum) -> new Crypto(rs.getString("currencyName"), rs.getString("currencyValues"), rs.getString("searchTime")));
		return cryptoStock.size()>0?(Crypto)cryptoStock.get(0): emptyCrypto;
	}
}
