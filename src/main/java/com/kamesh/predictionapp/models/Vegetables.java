package com.kamesh.predictionapp.models;

import javax.persistence.Embeddable;
import javax.persistence.Table;

//use @Embeddable instead of @Entity
@Embeddable
@Table(name="vegetables_table")
public class Vegetables {
	private String vegeName;
	private String vegeValues;
	private String searchTime;
	public Vegetables(String vegeName, String vegeValues, String searchTime) {
		super();
		this.vegeName = vegeName;
		this.vegeValues = vegeValues;
		this.searchTime = searchTime;
	}
	public String getVegeName() {
		return vegeName;
	}
	public void setVegeName(String vegeName) {
		this.vegeName = vegeName;
	}
	public String getVegeValues() {
		return vegeValues;
	}
	public void setVegeValues(String vegeValues) {
		this.vegeValues = vegeValues;
	}
	public String getSearchTime() {
		return searchTime;
	}
	public void setSearchTime(String searchTime) {
		this.searchTime = searchTime;
	}
}
