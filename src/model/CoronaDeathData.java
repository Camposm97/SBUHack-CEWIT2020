package model;

import java.util.LinkedList;

public class CoronaDeathData {
	private String provinceOrState;
	private String countryOrRegion;
	private String latitude;
	private String longitude;
	private LinkedList<Integer> numberOfDeaths;
	
	public CoronaDeathData(String provinceOrState, String countryOrRegion, String latitude, String longitude,
			LinkedList<Integer> numberOfDeaths) {
		super();
		this.provinceOrState = provinceOrState;
		this.countryOrRegion = countryOrRegion;
		this.latitude = latitude;
		this.longitude = longitude;
		this.numberOfDeaths = numberOfDeaths;
	}
	public String getProvinceOrState() {
		return provinceOrState;
	}
	public void setProvinceOrState(String provinceOrState) {
		this.provinceOrState = provinceOrState;
	}
	public String getCountryOrRegion() {
		return countryOrRegion;
	}
	public void setCountryOrRegion(String countryOrRegion) {
		this.countryOrRegion = countryOrRegion;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public LinkedList<Integer> getNumberOfDeaths() {
		return numberOfDeaths;
	}
	public void setNumberOfDeaths(LinkedList<Integer> numberOfDeaths) {
		this.numberOfDeaths = numberOfDeaths;
	}
	
	
	
}
