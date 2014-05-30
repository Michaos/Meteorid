package com.android.meteorid.dao;

import java.util.ArrayList;

public class City {

	private int id;
	private String name;
	private Integer temperature;
	private ArrayList<Day> dayList;
	
	public City(int id, String name, Integer temperature, ArrayList<Day> dayList) {
		this.id = id;
		this.name = name;
		this.temperature = temperature;
		this.dayList = dayList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTemperature() {
		return temperature;
	}

	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}

	public ArrayList<Day> getDayList() {
		return dayList;
	}

	public void setDayList(ArrayList<Day> dayList) {
		this.dayList = dayList;
	}
}