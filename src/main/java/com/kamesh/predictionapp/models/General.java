package com.kamesh.predictionapp.models;

import javax.persistence.Embeddable;
import javax.persistence.Table;

//use @Embeddable instead of @Entity
@Embeddable
@Table(name="general_table")
public class General {
	private String companyName;
	private String generalValues;
	private String searchTime;
	public General(String companyName, String generalValues, String searchTime) {
		super();
		this.companyName = companyName;
		this.generalValues = generalValues;
		this.searchTime = searchTime;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getGeneralValues() {
		return generalValues;
	}
	public void setGeneralValues(String generalValues) {
		this.generalValues = generalValues;
	}
	public String getSearchTime() {
		return searchTime;
	}
	public void setSearchTime(String searchTime) {
		this.searchTime = searchTime;
	}
	
}
