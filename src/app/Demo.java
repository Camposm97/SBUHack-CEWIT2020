package app;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import model.CoronaData;
import model.CoronaVirusInfo;
import util.CamposUtils;
import util.DataImport;

public class Demo {

	public static void main(String[] args) throws IOException {
//		LinkedList<CoronaVirusInfo> cvi;
//		File[] arrayOfDates=CamposUtils.scanFiles("res/csse_covid_19_data/csse_covid_19_daily_reports");
//		//File fileForCorona= new File("res/csse_covid_19_data/csse_covid_19_daily_reports/01-22-2020.csv");
//		LinkedList<LinkedList<CoronaVirusInfo>> listOfCases = new LinkedList<>();
//		for (int i=0;i<arrayOfDates.length;i++) {
//			cvi=DataImport.importCoronaData(arrayOfDates[i]);
//			listOfCases.add(cvi);
//		}
//		System.out.println(listOfCases.get(3).get(3).getStateOrCountry());
		LinkedList<CoronaData> cdd=DataImport.importDeathData("https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/archived_data/time_series/time_series_2019-ncov-Deaths.csv");
		LinkedList<CoronaData> ccd=DataImport.importConfirmedData("https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv");
		LinkedList<CoronaData> crd=DataImport.importRecoveredData("https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Recovered.csv");
		System.out.println(cdd.get(1).getDeathsConfirmedOrRecovered());
		System.out.println(crd.get(1).getDeathsConfirmedOrRecovered().get(3));
	}

}
