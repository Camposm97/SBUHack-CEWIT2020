package app;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import model.CoronaDeathData;
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
		LinkedList<CoronaDeathData> cdd=DataImport.importDeathData("https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/archived_data/time_series/time_series_2019-ncov-Deaths.csv");
		System.out.println(cdd.get(1).getNumberOfDeaths().get(3));
	}

}
