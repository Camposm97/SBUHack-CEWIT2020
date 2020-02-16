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
	
	private VBox comparisonBox;
	private VBox box2;
	private HBox boxs;
	private Label title;
	
	public TotalsBox(BarChart totals) {

		comparisonBox = new VBox();
		comparisonBox.setAlignment(Pos.CENTER);
		
//		List<CoronaData> listC = App.DB.getCoronaConfirmed();
//		List<CoronaData> listD = App.DB.getCoronaDeaths();
//		List<CoronaData> listR = App.DB.getCoronaRecovered();
//		XYChart.Series<String, Number> seriesC = new XYChart.Series<>();
//		XYChart.Series<String, Number> seriesD = new XYChart.Series<>();
//		XYChart.Series<String, Number> seriesR = new XYChart.Series<>();
//		for(CoronaData corona: listC) {
//			LinkedList<Integer> countListC = corona.getCountList();
//			for(int i=0; i<countListC.size(); i++) {
//				seriesC.getData().add(new Data<String, Number>("Confirmed", countListC.get(i)));
//			}
//		}
//		
//		for(CoronaData corona: listD) {
//			LinkedList<Integer> countListD = corona.getCountList();
//			for(int i=0; i<countListD.size(); i++) {
//				seriesD.getData().add(new Data<String, Number>("Deaths", countListD.get(i)));
//			}
//		}
//		
//		for(CoronaData corona: listR) {
//			LinkedList<Integer> countListR = corona.getCountList();
//			for(int i=0; i<countListR.size(); i++) {
//				seriesR.getData().add(new Data<String, Number>(i, countListR.get(i)));
//			}
//		}
		int totalC = App.DB.getTotalConfirmed();
		int totalD = App.DB.getTotalDeaths();
		int totalR = App.DB.getTotalRecovered();
		XYChart.Series<String, Number> totalSeries = new XYChart.Series<String, Number>();
		totalSeries.getData().add(new Data<String, Number>("Confirmed", totalC));
		totalSeries.getData().add(new Data<String, Number>("Deaths", totalD));
		totalSeries.getData().add(new Data<String, Number>("Recovered", totalR));
		totals.getData().add(totalSeries);
		comparisonBox.getChildren().add(totals);
	}
	
	public VBox getTotalsBox() {
		return comparisonBox;
	}
}
