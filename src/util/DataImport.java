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
		String city=null;
		String province = null;
		String stateOrCountry = null;
		String lastUpdate = null;
		int confirmedCases = 0;
		int deaths = 0;
		int recovered = 0;
		in.nextLine();
		while (in.hasNextLine()) {
			String currentLine = CamposUtils.editCommas(in.nextLine());
			String[] tokens = currentLine.split(",");
			if (tokens.length==7) {
				if (currentLine.charAt(0) == ',') {
					city = "none";
				}
				else {
					city = tokens[0];
				}
				province = tokens[1];
				stateOrCountry = tokens[2];
				lastUpdate=tokens[3];
				if (tokens[4].equals(" ")) {
					confirmedCases=0;
				}
				else {
					confirmedCases=Integer.parseInt(tokens[4].trim());
				}
				if (tokens[5].equals(" ")) {
					deaths=0;
				}
				else {
					deaths=Integer.parseInt(tokens[5].trim());
				}
				if (tokens[6].equals(" ")) {
					recovered=0;
				}
				else {
					recovered=Integer.parseInt(tokens[6].trim());
				}
				CoronaVirusInfo cvi = new CoronaVirusInfo(city,province, stateOrCountry, lastUpdate, confirmedCases, deaths,
						recovered);
				theList.add(cvi);
			}
		if(tokens.length==6) {
			if (currentLine.charAt(0) == ',') {
				province = "none";
			}
			else {
				province = tokens[0];
			}
			stateOrCountry = tokens[1];
			lastUpdate = tokens[2];
			if (tokens[3].equals(" ")) {
				confirmedCases=0;
			}
			else {
				confirmedCases=Integer.parseInt(tokens[3].trim());
			}
			if (tokens[4].equals(" ")) {
				deaths=0;
			}
			else {
				deaths=Integer.parseInt(tokens[4].trim());
			}
			if (tokens[5].equals(" ")) {
				recovered=0;
			}
			else {
				recovered=Integer.parseInt(tokens[5].trim());
			}
			CoronaVirusInfo cvi = new CoronaVirusInfo(province, stateOrCountry, lastUpdate, confirmedCases, deaths,
					recovered);
			theList.add(cvi);
		}
//			else if (tokens.length==3) {
//				province = tokens[0];
//				stateOrCountry = tokens[1];
//				lastUpdate = tokens[2];
//				confirmedCases = 0;
//				deaths = 0;
//				recovered = 0;
//			}
//			else if (tokens.length == 4) {
//				province = tokens[0];
//				stateOrCountry = tokens[1];
//				lastUpdate = tokens[2];
//				confirmedCases = Integer.parseInt(tokens[3]);
//				deaths = 0;
//				recovered = 0;
//			}
//			else if (tokens.length == 5) {
//				province = tokens[0];
//				stateOrCountry = tokens[1];
//				lastUpdate = tokens[2];
//				confirmedCases = Integer.parseInt(tokens[3]);
//				deaths = Integer.parseInt(tokens[4]);
//				recovered = 0;
//			}
//			else if (tokens.length==6) {
//				province = tokens[0];
//				stateOrCountry = tokens[1];
//				lastUpdate = tokens[2];
//				confirmedCases = Integer.parseInt(tokens[3]);
//				deaths = Integer.parseInt(tokens[4]);
//				recovered = Integer.parseInt(tokens[5]);
//			}
		}
		return theList;
	}
}
