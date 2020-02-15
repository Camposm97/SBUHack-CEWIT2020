package model;

import java.util.LinkedList;

public class CoronaDatabase {
	private LinkedList<CoronaData> coronaDeaths;
	private LinkedList<CoronaData> coronaRecovered;
	private LinkedList<CoronaData> coronaConfirmed;
	public CoronaDatabase(LinkedList<CoronaData> coronaDeaths, LinkedList<CoronaData> coronaRecovered,
			LinkedList<CoronaData> coronaConfirmed) {
		super();
		this.coronaDeaths = coronaDeaths;
		this.coronaRecovered = coronaRecovered;
		this.coronaConfirmed = coronaConfirmed;
	}
	public LinkedList<CoronaData> getCoronaDeaths() {
		return coronaDeaths;
	}
	public void setCoronaDeaths(LinkedList<CoronaData> coronaDeaths) {
		this.coronaDeaths = coronaDeaths;
	}
	public LinkedList<CoronaData> getCoronaRecovered() {
		return coronaRecovered;
	}
	public void setCoronaRecovered(LinkedList<CoronaData> coronaRecovered) {
		this.coronaRecovered = coronaRecovered;
	}
	public LinkedList<CoronaData> getCoronaConfirmed() {
		return coronaConfirmed;
	}
	public void setCoronaConfirmed(LinkedList<CoronaData> coronaConfirmed) {
		this.coronaConfirmed = coronaConfirmed;
	}
	
}
