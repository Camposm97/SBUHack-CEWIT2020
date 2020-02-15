package util;

import java.awt.Desktop;
import java.net.URI;

public class CamposWeb {
	public static final String GITHUB_MI = "https://github.com/Camposm97";
	public static final String GITHUB_KIEFER = "https://www.github.com/kiefuh";
	public static final String GITHUB_CHRIS = "https://www.github.com/The3FacesOfSteve";
	public static final String GITHUB_LEMUS = "https://www.github.com/LemusJ27"; 
	public static final String URL_CDC = "https://www.cdc.gov";
	public static final String URL_DONATE = "https://www.stjude.org/give.html?sc_dcm=254910812&sc_cid=kwp75674&source_code=IIQ190721002&ef_id=EAIaIQobChMIh8G8k_HT5wIVibWzCh1pgQDmEAAYASAAEgLjCvD_BwE:G:s&s_kwcid=AL!4519!3!322242236868!b!!g!!%2Bdonate&gclid=EAIaIQobChMIh8G8k_HT5wIVibWzCh1pgQDmEAAYASAAEgLjCvD_BwE";
	public static final String URL_TEMP = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
	
	public static void browse(String url) {
		try {
			Desktop desktop = Desktop.getDesktop();
			desktop.browse(new URI(url));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
