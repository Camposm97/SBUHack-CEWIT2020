package view;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import app.App;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.CoronaData;
import model.CoronaDatabase;
import util.DataParser;

public class TotalsBox {
	
	private HBox comparisonBox;
	
	public TotalsBox(BarChart totals) {

		comparisonBox = new HBox();
		comparisonBox.setAlignment(Pos.CENTER);
		
		int totalC = App.DB.getTotalConfirmed();
		int totalD = App.DB.getTotalDeaths();
		int totalR = App.DB.getTotalRecovered();
		XYChart.Series<String, Number> totalSeries = new XYChart.Series<String, Number>();
		totalSeries.getData().add(new Data<String, Number>("Confirmed", totalC));
		totalSeries.getData().add(new Data<String, Number>("Deaths", totalD));
		totalSeries.getData().add(new Data<String, Number>("Recovered", totalR));
		totals.getData().add(totalSeries);
		comparisonBox.getChildren().add(totals);
		comparisonBox.setMinHeight(600);
	}
	
	public HBox getTotalsBox() {
		return comparisonBox;
	}
}
