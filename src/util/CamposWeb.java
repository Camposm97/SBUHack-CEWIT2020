package util;

import java.awt.Desktop;
import java.net.URI;

public class CamposWeb {
	public static final String GITHUB_MI = "https://github.com/Camposm97";
	public static final String GITHUB_KIEFER = "https://www.github.com/kiefuh";
	public static final String GITHUB_CHRIS = "https://www.github.com/The3FacesOfSteve";
	public static final String GITHUB_LEMUS = "https://www.github.com/LemusJ27"; 
	public static final String URL_CDC = "https://www.cdc.gov";
	public static final String URL_DONATE = "https://www.directrelief.org/emergency/coronavirus-outbreak/";
	public static final String URL_SOURCE = "https://github.com/CSSEGISandData/COVID-19/tree/master/csse_covid_19_data/csse_covid_19_daily_reports";
	
	public static void browse(String url) {
		try {
			Desktop desktop = Desktop.getDesktop();
			desktop.browse(new URI(url));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
