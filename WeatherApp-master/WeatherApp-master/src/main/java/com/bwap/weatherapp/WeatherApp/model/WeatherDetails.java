package com.bwap.weatherapp.WeatherApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WeatherDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int temp_max;
	private int temp_min;
	private int  pressure;
	private int humidity;
	private int speed;
	private double feels_like;
	public int getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(int temp_max) {
		this.temp_max = temp_max;
	}
	public int getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(int temp_min) {
		this.temp_min = temp_min;
	}
	public int getPressure() {
		return pressure;
	}
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public double getFeels_like() {
		return feels_like;
	}
	public void setFeels_like(double feels_like) {
		this.feels_like = feels_like;
	}
	
	
	

}
