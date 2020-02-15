package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;

import model.CoronaData;
import model.CoronaVirusInfo;
import model.SavedCoronaData;

public class DataImport {
	private static final int VALID_RESPONSE_CODE = 200;
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
		in.nextLine();
		while (in.hasNextLine()) {
			String currentLine = CamposUtils.editCommas(in.nextLine());
			String[] tokens = currentLine.split(",");
			if (tokens.length == 7) {
				theList.add(ifSevenScraper(tokens, currentLine));
			}
			if (tokens.length == 6) {
				//theList.add(ifSixScraper(tokens, currentLine));
			}
		}
		return theList;
	}
	
	public static LinkedList<CoronaData> importDeathData(String url1) throws IOException {
		String s = url1;
		String inLine = "";
		URL url = new URL(s);
		LinkedList<CoronaData> listCDD= new LinkedList<>();
		HttpsURLConnection c = (HttpsURLConnection) url.openConnection();
		c.setRequestMethod("GET");
		c.connect();
		int responseCode = c.getResponseCode();
		if (responseCode != VALID_RESPONSE_CODE) {
			throw new RuntimeException("HttpResponseCode: " + responseCode);
		} else {
			System.out.println("Valid Response Code: " + responseCode);
			Scanner sc = new Scanner(url.openStream());
			sc.nextLine();
			sc.nextLine();
			while (sc.hasNextLine()) {
				inLine = editCommas(sc.nextLine());
				String provinceOrState;
				String countryOrRegion;
				String latitude;
				String longitude;
				int numberOfDeaths;
				LinkedList<Integer> daysOfDeaths= new LinkedList<>();
				String tokens[]=inLine.split(",");
				if (inLine.charAt(0) == ',') {
					provinceOrState = "none";
				}else {
					provinceOrState=tokens[0];
				}
				countryOrRegion=tokens[1];
				latitude=tokens[2];
				longitude=tokens[3];
				for (int i=4;i<tokens.length;i++) {
					if(tokens[i].equals(" ")) {
						numberOfDeaths=0;
					}else {
						numberOfDeaths=(int)Double.parseDouble(tokens[i].trim());
					}
					daysOfDeaths.add(numberOfDeaths);
				}
				CoronaData cdd= new CoronaData(provinceOrState,countryOrRegion,latitude,longitude,daysOfDeaths);
				listCDD.add(cdd);
			}
			return listCDD;
		}
		
	}
	
	public static SavedCoronaData importCorona() throws IOException {
		LinkedList<CoronaData> cdd=DataImport.importDeathData("https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/archived_data/time_series/time_series_2019-ncov-Deaths.csv");
		LinkedList<CoronaData> ccd=DataImport.importConfirmedData("https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv");
		LinkedList<CoronaData> crd=DataImport.importRecoveredData("https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Recovered.csv");
		SavedCoronaData saveCorona= new SavedCoronaData(cdd,crd,ccd);
		return saveCorona;
	}
	
	public static LinkedList<CoronaData> importConfirmedData(String url1) throws IOException {
		String s = url1;
		String inLine = "";
		URL url = new URL(s);
		LinkedList<CoronaData> listCDD= new LinkedList<>();
		HttpsURLConnection c = (HttpsURLConnection) url.openConnection();
		c.setRequestMethod("GET");
		c.connect();
		int responseCode = c.getResponseCode();
		if (responseCode != VALID_RESPONSE_CODE) {
			throw new RuntimeException("HttpResponseCode: " + responseCode);
		} else {
			System.out.println("Valid Response Code: " + responseCode);
			Scanner sc = new Scanner(url.openStream());
			sc.nextLine();
			sc.nextLine();
			while (sc.hasNextLine()) {
				inLine = editCommas(sc.nextLine());
				String provinceOrState;
				String countryOrRegion;
				String latitude;
				String longitude;
				int numberOfConfirmed;
				LinkedList<Integer> daysOfDeaths= new LinkedList<>();
				String tokens[]=inLine.split(",");
				if (inLine.charAt(0) == ',') {
					provinceOrState = "none";
				}else {
					provinceOrState=tokens[0];
				}
				countryOrRegion=tokens[1];
				latitude=tokens[2];
				longitude=tokens[3];
				for (int i=4;i<tokens.length;i++) {
					if(tokens[i].equals(" ")) {
						numberOfConfirmed=0;
					}else {
						numberOfConfirmed=(int)Double.parseDouble(tokens[i].trim());
					}
					daysOfDeaths.add(numberOfConfirmed);
				}
				CoronaData cdd= new CoronaData(provinceOrState,countryOrRegion,latitude,longitude,daysOfDeaths);
				listCDD.add(cdd);
			}
			return listCDD;
		}
		
	}
	
	public static LinkedList<CoronaData> importRecoveredData(String url1) throws IOException {
		String s = url1;
		String inLine = "";
		URL url = new URL(s);
		LinkedList<CoronaData> listCDD= new LinkedList<>();
		HttpsURLConnection c = (HttpsURLConnection) url.openConnection();
		c.setRequestMethod("GET");
		c.connect();
		int responseCode = c.getResponseCode();
		if (responseCode != VALID_RESPONSE_CODE) {
			throw new RuntimeException("HttpResponseCode: " + responseCode);
		} else {
			System.out.println("Valid Response Code: " + responseCode);
			Scanner sc = new Scanner(url.openStream());
			sc.nextLine();
			sc.nextLine();
			String currentLine;
			while (sc.hasNextLine()) {
				inLine =editCommas( sc.nextLine());
				String provinceOrState;
				String countryOrRegion;
				String latitude;
				String longitude;
				int numberOfRecovered;
				LinkedList<Integer> daysOfDeaths= new LinkedList<>();
				String tokens[]=inLine.split(",");
				if (inLine.charAt(0) == ',') {
					provinceOrState = "none";
				}else {
					provinceOrState=tokens[0];
				}
				countryOrRegion=tokens[1];
				latitude=tokens[2];
				longitude=tokens[3];
				for (int i=4;i<tokens.length;i++) {
					if(tokens[i].equals(" ")) {
						numberOfRecovered=0;
					}else {
						numberOfRecovered=(int)Double.parseDouble(tokens[i].trim());
					}
					daysOfDeaths.add(numberOfRecovered);
				}
				CoronaData cdd= new CoronaData(provinceOrState,countryOrRegion,latitude,longitude,daysOfDeaths);
				listCDD.add(cdd);
			}
			return listCDD;
		}
		
	}
	private static CoronaVirusInfo ifSevenScraper(String[] tokens, String currentLine) {
		String city = null;
		String province = null;
		String stateOrCountry = null;
		String lastUpdate = null;
		int confirmedCases = 0;
		int deaths = 0;
		int recovered = 0;
		if (currentLine.charAt(0) == ',') {
			city = "none";
		} else {
			city = tokens[0];
		}
		province = tokens[1];
		stateOrCountry = tokens[2];
		lastUpdate = tokens[3];
		if (tokens[4].equals(" ")) {
			confirmedCases = 0;
		} else {
			confirmedCases = Integer.parseInt(tokens[4].trim());
		}
		if (tokens[5].equals(" ")) {
			deaths = 0;
		} else {
			deaths = Integer.parseInt(tokens[5].trim());
		}
		if (tokens[6].equals(" ")) {
			recovered = 0;
		} else {
			recovered = Integer.parseInt(tokens[6].trim());
		}
		CoronaVirusInfo cvi = new CoronaVirusInfo(city, province, stateOrCountry, lastUpdate, confirmedCases, deaths,
				recovered);
		return cvi;
	}
	
	public static String editCommas(String s) {
		s = s.replaceAll(", ", " ");
		return s.replaceAll(",", ", ");
	}
}
