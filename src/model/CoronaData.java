package model;

import java.util.LinkedList;

public class CoronaData {
	private String provinceOrState;
	private String countryOrRegion;
	private String latitude;
	private String longitude;
	private LinkedList<Integer> countList;
	private int latestCount;

	public CoronaData(String provinceOrState, String countryOrRegion, String latitude, String longitude,
			LinkedList<Integer> countList) {
		super();
		this.provinceOrState = provinceOrState;
		this.countryOrRegion = countryOrRegion;
		this.latitude = latitude;
		this.longitude = longitude;
		this.countList = countList;
		this.latestCount = countList.getLast();
	}

	public String getProvinceOrState() {
		return provinceOrState;
	}

	public String getCountryOrRegion() {
		return countryOrRegion;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public LinkedList<Integer> getCountList() {
		return countList;
	}
	
	public int getLatestCount() {
		return latestCount;
	}
}
