package util;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import model.CoronaData;
import model.CoronaDatabase;

public class CamposParser {
	private static final String TIME_SERIES_DEATHS_2019 = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/archived_data/time_series/time_series_2019-ncov-Deaths.csv";
	private static final String TIME_SERIES_CONFIRMED_2019 = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";
	private static final String TIME_SERIES_RECOVERED_2019 = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Recovered.csv";
	private static final int VALID_RESPONSE_CODE = 200;

	public static CoronaDatabase importCoronaDB() {
		try {
			LinkedList<CoronaData> cdd = CamposParser.importCoronaData(TIME_SERIES_DEATHS_2019);
			LinkedList<CoronaData> ccd = CamposParser.importCoronaData(TIME_SERIES_CONFIRMED_2019);
			LinkedList<CoronaData> crd = CamposParser.importCoronaData(TIME_SERIES_RECOVERED_2019);
			CoronaDatabase db = new CoronaDatabase(cdd, crd, ccd);
			return db;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static URL connectTo(String str) {
		URL url = null;
		try {
			url = new URL(str);
			HttpsURLConnection c = (HttpsURLConnection) url.openConnection();
			c.setRequestMethod("GET");
			c.connect();
			int responseCode = c.getResponseCode();
			if (responseCode != VALID_RESPONSE_CODE) {
				throw new RuntimeException("HttpResponseCode: " + responseCode);
			} else {
				System.out.println("Valid Response Code: " + responseCode);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	public static LinkedList<CoronaData> importCoronaData(String str) throws IOException {
		String currentLine;
		URL url = connectTo(str);
		LinkedList<CoronaData> list = new LinkedList<>();
		Scanner in = new Scanner(url.openStream());
		in.nextLine();
		in.nextLine();
		while (in.hasNextLine()) {
			currentLine = editCommas(in.nextLine());
			String provinceOrState, countryOrRegion;
			String latitude, longitude;
			int numberOfDeaths;
			LinkedList<Integer> countList = new LinkedList<>();
			String[] tokens = currentLine.split(",");
			
			if (currentLine.charAt(0) == ',') {
				provinceOrState = "none";
			} else {
				provinceOrState = tokens[0];
			}

			countryOrRegion = tokens[1];
			latitude = tokens[2];
			longitude = tokens[3];

			for (int i = 4; i < tokens.length; i++) {
				if (tokens[i].equals(" ")) {
					numberOfDeaths = 0;
				} else {
					numberOfDeaths = (int) Double.parseDouble(tokens[i].trim());
				}
				countList.add(numberOfDeaths);
			}

			CoronaData cdd = new CoronaData(provinceOrState, countryOrRegion, latitude, longitude, countList);
			list.add(cdd);
		}
		in.close();
		return list;
	}

	public static String editCommas(String s) {
		s = s.replaceAll(", ", " ");
		return s.replaceAll(",", ", ");
	}
}
