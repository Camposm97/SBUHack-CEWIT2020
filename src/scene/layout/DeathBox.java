package scene.layout;

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

public class DeathBox {
	private VBox deathBox;
	private VBox chartBox;

	public DeathBox(LineChart chart) {
		deathBox = new VBox();
		deathBox.setAlignment(Pos.CENTER);
		
		chart.getYAxis().setLabel("Death Cases");
		
		XYChart.Series dataSet1 = new XYChart.Series<>();
		dataSet1.setName("Death Cases");
		
		//TO-DO: Write a loop to either read all data files or make a navigator to identify
		//the day being analyzed
		dataSet1.getData().add(new XYChart.Data(0, 1));
		dataSet1.getData().add(new XYChart.Data(2, 1));
		dataSet1.getData().add(new XYChart.Data(7, 6));
		
		chart.getData().add(dataSet1);
		chart.setTitle("Death Cases");
		chartBox = new VBox(chart);
		
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

		deathBox.getChildren().addAll(chartBox, bt);
	}
	
	public VBox getDeathBox() {
		return deathBox;
	}
}
