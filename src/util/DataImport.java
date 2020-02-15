package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import model.CoronaVirusInfo;

public class DataImport {
	public static LinkedList<CoronaVirusInfo> importCoronaData(File importFile) {
		File f = importFile;
		Scanner in;
		LinkedList<CoronaVirusInfo> theList = new LinkedList<>();
		try {
			in = new Scanner(f);
		} catch (FileNotFoundException e) {
			in = null;
			e.printStackTrace();
		}
		String province;
		String stateOrCountry;
		String lastUpdate;
		int confirmedCases;
		int deaths;
		int recovered;
		while (in.hasNextLine()) {
			String currentLine = in.nextLine();
			String[] tokens = currentLine.split(",");
			if (currentLine.charAt(0) == ',') {
				province = "none";
			}
			if (currentLine.length() == 3) {
				province = tokens[0];
				stateOrCountry = tokens[1];
				lastUpdate = tokens[2];
				confirmedCases = 0;
				deaths = 0;
				recovered = 0;
			}
			if (currentLine.length() == 4) {
				province = tokens[0];
				stateOrCountry = tokens[1];
				lastUpdate = tokens[2];
				confirmedCases = Integer.parseInt(tokens[3]);
				deaths = 0;
				recovered = 0;
			}
			if (currentLine.length() == 5) {
				province = tokens[0];
				stateOrCountry = tokens[1];
				lastUpdate = tokens[2];
				confirmedCases = Integer.parseInt(tokens[3]);
				deaths = Integer.parseInt(tokens[4]);
				recovered = 0;
			} else {
				province = tokens[0];
				stateOrCountry = tokens[1];
				lastUpdate = tokens[2];
				confirmedCases = Integer.parseInt(tokens[3]);
				deaths = Integer.parseInt(tokens[4]);
				recovered = Integer.parseInt(tokens[5]);
			}
			CoronaVirusInfo cvi = new CoronaVirusInfo(province, stateOrCountry, lastUpdate, confirmedCases, deaths,
					recovered);
			theList.add(cvi);
		}
		return theList;
	}
}
