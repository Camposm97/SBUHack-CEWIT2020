package util;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import app.App;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.Chart;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class CamposUtils {
	public static final Insets DEFAULT_INSETS = new Insets(10);
	public static File[] scanFiles(String dir) {
		return new File(dir).listFiles();
	}
	
	public static String editCommas(String s) {
		s = s.replaceAll(", ", " ");
		return s.replaceAll(",", ", ");
	}
	
	public static void saveGraph(Chart chart) {
		WritableImage image = chart.snapshot(new SnapshotParameters(), null);	   
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("PNG", ".png"));
	    File file = fc.showSaveDialog(new Stage());
	    if (file != null) {
	    	try {
		        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
		        AlertHelper.showInfo(App.TITLE, "Successfully saved image!", "Image saved at: " + file.getAbsolutePath());
		    } catch (IOException ex) {
		    	ex.printStackTrace();
		    }
	    }
	}
}
