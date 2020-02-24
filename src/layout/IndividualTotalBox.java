package layout;

import java.util.HashMap;
import java.util.Map;

import app.App;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.layout.HBox;

public class IndividualTotalBox {
	private HBox comparisonBox;

	public IndividualTotalBox(BarChart totals) {
		HashMap<String,Integer> hM=App.DB.getCountries();
		comparisonBox = new HBox();
		comparisonBox.setAlignment(Pos.CENTER);
		
//		int totalC = App.DB.getTotalConfirmed();
//		int totalD = App.DB.getTotalDeaths();
//		int totalR = App.DB.getTotalRecovered();
		XYChart.Series<String, Number> totalSeries = new XYChart.Series<String, Number>();
		for (Map.Entry<String, Integer> entry : hM.entrySet()) {
			 totalSeries.getData().add(new Data<String, Number>(entry.getKey(),entry.getValue()));
		    }
		//totalSeries.getData().add(new Data<String, Number>("Confirmed", totalC));
//		totalSeries.getData().add(new Data<String, Number>("Deaths", totalD));
//		totalSeries.getData().add(new Data<String, Number>("Recovered", totalR));
		totals.getData().add(totalSeries);
		comparisonBox.getChildren().add(totals);
		comparisonBox.setMinHeight(600);
	}
	
	public HBox getTotalsBox() {
		return comparisonBox;
	}
}
