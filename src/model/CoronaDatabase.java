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

	public void setCoronaDeaths(List<CoronaData> coronaDeaths) {
		this.coronaDeaths = coronaDeaths;
	}

	public List<CoronaData> getCoronaRecovered() {
		return coronaRecovered;
	}

	public void setCoronaRecovered(List<CoronaData> coronaRecovered) {
		this.coronaRecovered = coronaRecovered;
	}

	public List<CoronaData> getCoronaConfirmed() {
		return coronaConfirmed;
	}

	public void setCoronaConfirmed(List<CoronaData> coronaConfirmed) {
		this.coronaConfirmed = coronaConfirmed;
	}

}
