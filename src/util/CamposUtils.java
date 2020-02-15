package util;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class CamposUtils {
	public static void main(String[] args) throws Exception {
		String s = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Recovered.csv";
		URL url = new URL(s);
		HttpsURLConnection c = (HttpsURLConnection) url.openConnection();
		c.setRequestMethod("GET");
		c.connect();
		Scanner in = new Scanner(url.openStream());
		while (in.hasNextLine()) {
			String currentLine = editCommas(in.nextLine());
//			System.out.println(currentLine);
			String[] tokens = currentLine.split(", ");
		}
		in.close();
	}
	
	public static File[] scanFiles(String dir) {
		return new File(dir).listFiles();
	}
	
	public static String editCommas(String s) {
		s = s.replaceAll(", ", " ");
		return s.replaceAll(",", ", ");
	}
}
