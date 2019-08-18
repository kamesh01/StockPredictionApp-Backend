package com.kamesh.predictionapp.models;

import javax.persistence.Embeddable;
import javax.persistence.Table;

//use @Embeddable instead of @Entity
@Embeddable
@Table(name="oil_table")
public class Oil {
	private String oilName;
	private String oilValues;
	private String searchTime;
	public Oil(String oilName, String oilValues, String searchTime) {
		super();
		this.oilName = oilName;
		this.oilValues = oilValues;
		this.searchTime = searchTime;
	}
	public String getOilName() {
		return oilName;
	}
	public void setOilName(String oilName) {
		this.oilName = oilName;
	}
	public String getOilValues() {
		return oilValues;
	}
	public void setOilValues(String oilValues) {
		this.oilValues = oilValues;
	}
	public String getSearchTime() {
		return searchTime;
	}
	public void setSearchTime(String searchTime) {
		this.searchTime = searchTime;
	}
}
