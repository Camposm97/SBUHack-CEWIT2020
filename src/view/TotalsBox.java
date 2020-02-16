package view;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

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
	
	private CoronaDatabase database;
	private VBox comparisonBox;
	private VBox box2;
	private HBox boxs;
	private Label title;
	
	public TotalsBox(BarChart totals) {
		try {
			database = DataParser.importCorona();
			database.display();
		} catch(IOException e) {
			e.printStackTrace();
		}
		comparisonBox = new VBox();
		comparisonBox.setAlignment(Pos.CENTER);
		
		totals.getXAxis().setLabel("Day");
		totals.getYAxis().setLabel("Cases");
		
		List<CoronaData> listC = database.getCoronaConfirmed();
		for(CoronaData corona: listC) {
			LinkedList<Integer> countList = corona.getDeathsConfirmedOrRecovered();
			XYChart.Series<Number, Number> series = new XYChart.Series<>();
			for(int i=0; i<countList.size(); i++) {
				series.getData().add(new Data<Number, Number>(i, countList.get(i)));
			}
		}
		
		XYChart.Series confirmedSet = new XYChart.Series<>();
		
		//TO-DO: Write a loop to either read all data files or make a navigator to identify
		//the day being analyzed
	}
	
	public VBox getTotalsBox() {
		return comparisonBox;
	}
}
