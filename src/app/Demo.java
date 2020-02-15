package app;

import java.io.File;
import java.util.LinkedList;

import model.CoronaVirusInfo;
import util.CamposUtils;
import util.DataImport;

public class Demo {

	public static void main(String[] args) {
		LinkedList<CoronaVirusInfo> cvi;
		File[] arrayOfDates=CamposUtils.scanFiles("res/csse_covid_19_data/csse_covid_19_daily_reports");
		//File fileForCorona= new File("res/csse_covid_19_data/csse_covid_19_daily_reports/01-22-2020.csv");
		LinkedList<LinkedList<CoronaVirusInfo>> listOfCases = new LinkedList<>();
		for (int i=0;i<arrayOfDates.length;i++) {
			cvi=DataImport.importCoronaData(arrayOfDates[i]);
			listOfCases.add(cvi);
		}
		System.out.println(listOfCases.get(3).get(3).getStateOrCountry());
	}

}
