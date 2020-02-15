package app;

import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class CamposDemo {
	private static final int VALID_RESPONSE_CODE = 200;

	public static void main(String[] args) throws Exception {
		String s = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/archived_data/time_series/time_series_2019-ncov-Deaths.csv";
		
		String inLine = "";
		URL url = new URL(s);
		HttpsURLConnection c = (HttpsURLConnection) url.openConnection();
		c.setRequestMethod("GET");
		c.connect();
		int responseCode = c.getResponseCode();
		if (responseCode != VALID_RESPONSE_CODE) {
			throw new RuntimeException("HttpResponseCode: " + responseCode);
		} else {
			System.out.println("Valid Response Code: " + responseCode);
			Scanner sc = new Scanner(url.openStream());
			while (sc.hasNextLine()) {
				inLine = sc.nextLine();
				System.out.println(inLine.replaceAll(",", ", "));
			}
		}
	}

}
