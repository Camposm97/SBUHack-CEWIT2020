package app;

import java.io.File;
import java.util.LinkedList;

import model.CoronaVirusInfo;
import util.DataImport;

public class Demo {

	public static void main(String[] args) {
		LinkedList<CoronaVirusInfo> cvi;
		File fileForCorona= new File("res/csse_covid_19_data/csse_covid_19_daily_reports/01-22-2020.csv");
		cvi=DataImport.importCoronaData(fileForCorona);
		System.out.println(cvi.get(2).getDeaths());
	}

}
