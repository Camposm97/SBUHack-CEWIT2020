package view;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Pos;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;

public class ConfirmedBox {
	private VBox confirmedBox;
	private VBox chartBox;
	
	public ConfirmedBox(LineChart chart) {
		confirmedBox = new VBox();
		confirmedBox.setAlignment(Pos.CENTER);
		
		chart.getYAxis().setLabel("Confirmed Cases");
		
		XYChart.Series dataSet1 = new XYChart.Series<>();
		dataSet1.setName("Confirmed Cases");
		
		//TO-DO: Write a loop to either read all data files or make a navigator to identify
		//the day being analyzed
		dataSet1.getData().add(new XYChart.Data(0, 1));
		dataSet1.getData().add(new XYChart.Data(1, 3));
		dataSet1.getData().add(new XYChart.Data(2, 5));
		dataSet1.getData().add(new XYChart.Data(3, 19));
		dataSet1.getData().add(new XYChart.Data(4, 54));
		dataSet1.getData().add(new XYChart.Data(5, 286));
		
		chart.getData().add(dataSet1);
		chart.setTitle("Confirmed Cases");
		chartBox = new VBox(chart);
		
		// Code by Michael
		Button bt = new Button("Click");
		bt.setOnAction(e -> {
			WritableImage image = chart.snapshot(new SnapshotParameters(), null);
		    
		    // TODO: probably use a file chooser here
		    File file = new File("chart.png");
		    
		    try {
		        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
		    } catch (IOException ex) {
		    	ex.printStackTrace();
		    }
		});
		// End of Code by Michael
		
		confirmedBox.getChildren().addAll(chartBox, bt); // Changed by Michael
	}
	
	public VBox getConfirmedBox() {
		return confirmedBox;
	}
}
