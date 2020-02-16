package view;

import java.io.IOException;

public class ExternalLink {

	private Runtime rt;
	public ExternalLink() {
		rt = Runtime.getRuntime();
	}
	
	public void openLink(String url) {
		try {
			rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
