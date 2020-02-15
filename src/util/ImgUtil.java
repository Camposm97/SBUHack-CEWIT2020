package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImgUtil {
	public static final String EXIT_ICO = "res/images/exit.png";
	public static final String GITHUB_ICO = "res/images/github.png";
	public static final String HISTORY_ICO = "res/images/history.png";
	public static final String CORONAVIRUS_ICO = "res/images/CoronaVirus.png";
	public static final String CDC_ICO = "res/images/cdc.png";
	public static final String ABOUT_ICO = "res/images/about.png";
	public static final String DONATE_ICO = "res/images/donate.png";
	public static final String SOURCES_ICO = "res/images/sources.png";
	public static final String MIKE_ICO = "res/images/mike.jpg";
	public static final String KIEFER_ICO = "res/images/kiefer.png";
	public static final String JOHN_ICO = "res/images/john.jpg";
	
	public static Image loadImg(String url) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(url));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return new Image(fis);
	}
	
	public static ImageView loadImgV(String url) {
		return new ImageView(loadImg(url));
	}
	
	public static ImageView loadImgVScale(String url,double height,double width) {
		Image image = loadImg(url);
		ImageView iv = new ImageView(image);
		iv.setFitHeight(height);
		iv.setFitWidth(width);
		return iv;
	}
	
}
