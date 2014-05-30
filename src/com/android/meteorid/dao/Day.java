package com.android.meteorid.dao;

import java.sql.Timestamp;

public class Day {
	
	private Timestamp timestamp;
	private int name;
	private Integer tempMin;
	private Integer tempMax;
	private String icon;
	
	public Day(Timestamp timestamp, int name, Integer tempMin, Integer tempMax, String icon) {
		this.timestamp = timestamp;
		this.name = name;
		this.tempMin = tempMin;
		this.tempMax = tempMax;
		this.icon = icon;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public Integer getTempMin() {
		return tempMin;
	}

	public void setTempMin(Integer tempMin) {
		this.tempMin = tempMin;
	}

	public Integer getTempMax() {
		return tempMax;
	}

	public void setTempMax(Integer tempMax) {
		this.tempMax = tempMax;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}