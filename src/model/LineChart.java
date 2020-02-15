package model;

import javafx.scene.chart.NumberAxis;

public class LineChart {
	NumberAxis xAxis;
	NumberAxis yAxis;
	
	public LineChart(NumberAxis xAxis, NumberAxis yAxis) {
		this.xAxis = xAxis;
		this.yAxis = yAxis;
	}
}
