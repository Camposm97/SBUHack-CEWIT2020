package view;

import app.App;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.layout.HBox;

public class TotalsBox {
	private HBox hBox;
	
	public TotalsBox(BarChart<String, Number> barChartTotals) {
		hBox = new HBox();
		hBox.setAlignment(Pos.CENTER);
		int totalC = App.DB.getTotalConfirmed();
		int totalD = App.DB.getTotalDeaths();
		int totalR = App.DB.getTotalRecovered();
		XYChart.Series<String, Number> totalSeries = new XYChart.Series<String, Number>();
		totalSeries.getData().add(new Data<String, Number>("Confirmed", totalC));
		totalSeries.getData().add(new Data<String, Number>("Deaths", totalD));
		totalSeries.getData().add(new Data<String, Number>("Recovered", totalR));
		barChartTotals.getData().add(totalSeries);
		hBox.getChildren().add(barChartTotals);
//		hBox.setMinHeight(600);
	}
	
	public HBox getTotalsBox() {
		return hBox;
	}
}
