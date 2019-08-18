package com.kamesh.predictionapp.models;

import javax.persistence.Embeddable;
import javax.persistence.Table;

//use @Embeddable instead of @Entity
@Embeddable
@Table(name="crypto_table")
public class Crypto {
	private String currencyName;
	private String currencyValues;
	private String searchTime;
	public Crypto(String currencyName, String currencyValues, String searchTime) {
		super();
		this.currencyName = currencyName;
		this.currencyValues = currencyValues;
		this.searchTime = searchTime;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public String getCurrencyValues() {
		return currencyValues;
	}
	public void setCurrencyValues(String currencyValues) {
		this.currencyValues = currencyValues;
	}
	public String getSearchTime() {
		return searchTime;
	}
	public void setSearchTime(String searchTime) {
		this.searchTime = searchTime;
	}
}
