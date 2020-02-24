package layout;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Pos;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;
import model.CoronaData;
import model.CoronaDatabase;
import util.KleisterParser;

public class ConfirmedBox {
	private VBox confirmedBox;
	private VBox chartBox;
	private List<CoronaData> list;
	private LinkedList<Integer> listConfirmed;
	private CoronaDatabase coronaDataBase;
	
	public ConfirmedBox(LineChart chart) {
		confirmedBox = new VBox();
		confirmedBox.setAlignment(Pos.CENTER);
		
		chart.getYAxis().setLabel("Confirmed Cases");
		XYChart.Series dataSet1 = new XYChart.Series<>();
		dataSet1.setName("Confirmed Cases");
		
		CoronaDatabase database = KleisterParser.importCoronaDB();
		list = database.getCoronaDeaths();
		
		for (int i = 0; i < database.getCoronaDeaths().size(); i++) {
			for (int j = 4; j < database.getCoronaDeaths().get(i).getCountList().size(); j++) {
				database.getCoronaDeaths().get(j).getCountList().get(j);
//				XYChart.Series prevSet = new XYChart.Series<>();
//				prevSet.getData().addAll(new XYChart.Data(j, list.get(j).getDeathsConfirmedOrRecovered().get(j)));
				dataSet1.getData().addAll(new XYChart.Data(j, (list.get(j - 1).getCountList().get(j - 1) + list.get(j).getCountList().get(j))));
//				prevSet = dataSet1;
			}
		}
//		for (int i = 4; i < listConfirmed.size(); i++) {
//			dataSet1.getData().add(new XYChart.Data(i, database.getCoronaConfirmed().get(i).getDeathsConfirmedOrRecovered().get(4)));
//		}
		
		//TO-DO: Write a loop to either read all data files or make a navigator to identify
		//the day being analyzed
//		dataSet1.getData().add(new XYChart.Data(0, 1));
//		dataSet1.getData().add(new XYChart.Data(1, 3));
//		dataSet1.getData().add(new XYChart.Data(2, 5));
//		dataSet1.getData().add(new XYChart.Data(3, 19));
//		dataSet1.getData().add(new XYChart.Data(4, 54));
//		dataSet1.getData().add(new XYChart.Data(5, 286));
		
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
