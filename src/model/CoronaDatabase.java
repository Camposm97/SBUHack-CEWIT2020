package model;

import java.util.List;

public class CoronaDatabase {
	private List<CoronaData> coronaDeaths;
	private List<CoronaData> coronaRecovered;
	private List<CoronaData> coronaConfirmed;

	public CoronaDatabase(List<CoronaData> coronaDeaths, List<CoronaData> coronaRecovered,
			List<CoronaData> coronaConfirmed) {
		this.coronaDeaths = coronaDeaths;
		this.coronaRecovered = coronaRecovered;
		this.coronaConfirmed = coronaConfirmed;
	}

	public List<CoronaData> getCoronaDeaths() {
		return coronaDeaths;
	}

	public List<CoronaData> getCoronaRecovered() {
		return coronaRecovered;
	}

	public List<CoronaData> getCoronaConfirmed() {
		return coronaConfirmed;
	}
	
	public int getTotalDeaths() {
		int count = 0;
		for (CoronaData cd : coronaDeaths) {
			count += cd.getDeathsConfirmedOrRecovered().getLast();
		}
		return count;
	}
	
	public int getTotalRecovered() {
		int count = 0;
		for (CoronaData cd : coronaRecovered) {
			count += cd.getDeathsConfirmedOrRecovered().getLast();
		}
		return count;
	}
	
	public int getTotalConfirmed() {
		int count = 0;
		for (CoronaData cd : coronaConfirmed) {
			count += cd.getDeathsConfirmedOrRecovered().getLast();
		}
		return count;
	}

	public void display() {
		System.out.println("Corona Deaths");
		for (CoronaData data : coronaDeaths) {
			System.out.println(data);
		}
		System.out.println();
		System.out.println("Corona Recovered");
		for (CoronaData data : coronaRecovered) {
			System.out.println(data);
		}
		System.out.println();
		System.out.println("Corona Confirmed");
		for (CoronaData data : coronaConfirmed) {
			System.out.println(data);
		}
		System.out.println("Done.");
	}

}
