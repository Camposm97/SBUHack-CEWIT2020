package view;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

public class TotalsBarSetup {
	
	private CategoryAxis xAxis;
	private NumberAxis yAxis;
	private BarChart<String, Number> barSetup;
	
	public TotalsBarSetup() {
		xAxis = new CategoryAxis();
		yAxis = new NumberAxis();
		barSetup = new BarChart<String, Number>(xAxis, yAxis);
		barSetup.setTitle("Total Cases");
		xAxis.setLabel("Country/Region");
		yAxis.setLabel("Cases");
	}
	
	public BarChart<String, Number> getBarChart() {
		return barSetup;
	}
}
