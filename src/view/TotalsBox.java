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
		
		List<CoronaData> listC = App.DB.getCoronaConfirmed();
		List<CoronaData> listD = App.DB.getCoronaDeaths();
		List<CoronaData> listR = App.DB.getCoronaRecovered();
		XYChart.Series<Number, Number> seriesC = new XYChart.Series<>();
		XYChart.Series<Number, Number> seriesD = new XYChart.Series<>();
		XYChart.Series<Number, Number> seriesR = new XYChart.Series<>();

		for(CoronaData corona: listC) {
			LinkedList<Integer> countListC = corona.getDeathsConfirmedOrRecovered();
			for(int i=0; i<countListC.size(); i++) {
				seriesC.getData().add(new Data<Number, Number>(i, countListC.get(i)));
			}
		}
		
		for(CoronaData corona: listD) {
			LinkedList<Integer> countListD = corona.getDeathsConfirmedOrRecovered();
			for(int i=0; i<countListD.size(); i++) {
				seriesD.getData().add(new Data<Number, Number>(i, countListD.get(i)));
			}
		}
		
		for(CoronaData corona: listR) {
			LinkedList<Integer> countListR = corona.getDeathsConfirmedOrRecovered();
			for(int i=0; i<countListR.size(); i++) {
				seriesR.getData().add(new Data<Number, Number>(i, countListR.get(i)));
			}
		}

		
	}
	
	public VBox getTotalsBox() {
		return comparisonBox;
	}
}
