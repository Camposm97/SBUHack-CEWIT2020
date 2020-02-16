package model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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

	public List<String> getCountriesInfected() {
		Set<String> hashSet = new HashSet<>();
		for (CoronaData cd : coronaDeaths) {
			hashSet.add(cd.getCountryOrRegion());
		}
		for (CoronaData cd : coronaRecovered) {
			hashSet.add(cd.getCountryOrRegion());
		}
		for (CoronaData cd : coronaConfirmed) {
			hashSet.add(cd.getCountryOrRegion());
		}
		List<String> list = new LinkedList<>(hashSet);
		return list;
	}
	
	

	public List<CoronaData> searchDeathsByArea(String key) {
		List<CoronaData> resultList = new LinkedList<>();
		for (int i = 0; i < coronaDeaths.size(); i++) {
			if (coronaDeaths.get(i).getCountryOrRegion().toLowerCase().contains(key.toLowerCase())
					|| coronaDeaths.get(i).getProvinceOrState().toLowerCase().contains(key.toLowerCase())) {
				resultList.add(coronaDeaths.get(i));
			}
		}
		return resultList;
	}

	public List<CoronaData> searchRecoveredByArea(String key) {
		List<CoronaData> resultList = new LinkedList<>();
		for (int i = 0; i < coronaRecovered.size(); i++) {
			if (coronaRecovered.get(i).getCountryOrRegion().toLowerCase().contains(key.toLowerCase())
					|| coronaRecovered.get(i).getProvinceOrState().toLowerCase().contains(key.toLowerCase())) {
				resultList.add(coronaRecovered.get(i));
			}
		}
		return resultList;
	}

	public List<CoronaData> searchConfirmedByArea(String key) {
		List<CoronaData> resultList = new LinkedList<>();
		for (int i = 0; i < coronaConfirmed.size(); i++) {
			if (coronaConfirmed.get(i).getCountryOrRegion().toLowerCase().contains(key.toLowerCase())
					|| coronaRecovered.get(i).getProvinceOrState().toLowerCase().contains(key.toLowerCase())) {
				resultList.add(coronaConfirmed.get(i));
			}
		}
		return resultList;
	}

	public int getTotalDeaths() {
		int count = 0;
		for (CoronaData cd : coronaDeaths) {
			count += cd.getCountList().getLast();
		}
		return count;
	}

	public int getTotalRecovered() {
		int count = 0;
		for (CoronaData cd : coronaRecovered) {
			count += cd.getCountList().getLast();
		}
		return count;
	}

	public int getTotalConfirmed() {
		int count = 0;
		for (CoronaData cd : coronaConfirmed) {
			count += cd.getCountList().getLast();
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
