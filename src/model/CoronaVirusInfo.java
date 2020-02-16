package model;

@Deprecated
public class CoronaVirusInfo {
//	private String city;
	private String province;
	private String stateOrCountry;
	private String lastUpdate;
	private int confirmedCases;
	private int deaths;
	private int recovered;
	public CoronaVirusInfo(String province, String stateOrCountry,  String lastUpdate, int confirmedCases,
			int deaths, int recovered) {
		super();
		this.province = province;
		this.stateOrCountry = stateOrCountry;
		this.lastUpdate = lastUpdate;
		this.confirmedCases = confirmedCases;
		this.deaths = deaths;
		this.recovered = recovered;
	}
	public CoronaVirusInfo(String city,String province, String stateOrCountry,  String lastUpdate, int confirmedCases,
			int deaths, int recovered) {
		super();
		this.province = province;
		this.stateOrCountry = stateOrCountry;
		this.lastUpdate = lastUpdate;
		this.confirmedCases = confirmedCases;
		this.deaths = deaths;
		this.recovered = recovered;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getStateOrCountry() {
		return stateOrCountry;
	}
	public void setStateOrCountry(String stateOrCountry) {
		this.stateOrCountry = stateOrCountry;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public int getConfirmedCases() {
		return confirmedCases;
	}
	public void setConfirmedCases(int confirmedCases) {
		this.confirmedCases = confirmedCases;
	}
	public int getDeaths() {
		return deaths;
	}
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	public int getRecovered() {
		return recovered;
	}
	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}
	
	
}
