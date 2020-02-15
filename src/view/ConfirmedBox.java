package view;

import javafx.geometry.Pos;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ConfirmedBox {
	private VBox confirmedBox;
	private VBox chartBox;
	private HBox box1;
	private Label title;
	
	public ConfirmedBox(LineChart chart) {
		confirmedBox = new VBox();
		confirmedBox.setAlignment(Pos.CENTER);
		
		chart.getYAxis().setLabel("Confirmed Cases");
		
		XYChart.Series dataSet1 = new XYChart.Series<>();
		dataSet1.setName("Confirmed Cases");
		dataSet1.getData().add(new XYChart.Data(0, 1));
		dataSet1.getData().add(new XYChart.Data(1, 3));
		dataSet1.getData().add(new XYChart.Data(2, 5));
		dataSet1.getData().add(new XYChart.Data(3, 19));
		dataSet1.getData().add(new XYChart.Data(4, 54));
		dataSet1.getData().add(new XYChart.Data(5, 286));
		chart.getData().add(dataSet1);
		chart.setTitle("Confirmed Cases");
		chartBox = new VBox(chart);
		
		confirmedBox.getChildren().addAll(chartBox);
	}
	
	public VBox getConfirmedBox() {
		return confirmedBox;
	}
}
