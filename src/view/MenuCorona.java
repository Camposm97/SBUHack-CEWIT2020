package view;

<<<<<<< HEAD
//>>>>>>> 9ae94d5f6f68f5ac5eb20acfe2c9a5a1294ede75
=======


import java.io.IOException;

import app.App;

import java.io.IOException;


import java.io.IOException;


>>>>>>> 32dda31e329b619e5aa069eddfa25ba620e6b70c
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import util.ImgUtil;

public class MenuCorona extends Menu {
	private MenuItem miConfirmedCases, miDeaths, miRecoveries, miTotals, miPieChart;
	private LineChart chartConfirmed, chartDeath, chartRecovery;
	
	public MenuCorona(BorderPane root) {
		super("Coronavirus");
		
		miConfirmedCases = new MenuItem("Confirmed Cases");
		miDeaths = new MenuItem("Deaths");
		miRecoveries = new MenuItem("Recoveries");
<<<<<<< HEAD
		miPieChart = new MenuItem("Pie Chart");
=======
		miTotals = new MenuItem("Totals");
>>>>>>> 32dda31e329b619e5aa069eddfa25ba620e6b70c
		
		chartConfirmed = makeChart();
		chartDeath = makeChart();
		chartRecovery = makeChart();

		TotalsBarSetup barSet = new TotalsBarSetup();
		
		ConfirmedBox bigCBox = new ConfirmedBox(chartConfirmed);
		VBox confirmedBox = bigCBox.getConfirmedBox();
		DeathBox bigDBox = new DeathBox(chartDeath);
		VBox deathBox = bigDBox.getDeathBox();
		RecoveryBox bigRBox = new RecoveryBox(chartRecovery);
		VBox recoveryBox = bigRBox.getRecoveryBox();
<<<<<<< HEAD
		TotalsBox bigTBox = new TotalsBox(chartTotals);
		VBox totalsBox = bigTBox.getTotalsBox();
		PieChartBox bigPBox = new PieChartBox();
		VBox pieChartBox = bigPBox.getPieChartBox();
=======
		TotalsBox bigTBox = new TotalsBox(barSet.getBarChart());
		HBox totalsBox = bigTBox.getTotalsBox();
>>>>>>> 32dda31e329b619e5aa069eddfa25ba620e6b70c
		
		miConfirmedCases.setOnAction(e -> {
			root.setCenter(new CoronaConfirmedSearchPane());
		});

		miDeaths.setOnAction(e -> {
			root.setCenter(new CoronaDeathSearchPane());
		});

		miRecoveries.setOnAction(e -> {
			root.setCenter(new CoronaRecoveredSearchPane());
		});
		
		miTotals.setOnAction(e -> {
			root.setCenter(totalsBox);
		});
		
		miPieChart.setOnAction(e -> {
			root.setCenter(pieChartBox);
		});
		
		this.getItems().addAll(miConfirmedCases, miDeaths, miRecoveries, miTotals, miPieChart);
		this.setGraphic(ImgUtil.loadImgVScale(ImgUtil.CORONAVIRUS_ICO,16.0,16.0));
	}
	
	public LineChart makeChart() {
		NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel("Days");
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Cases");
		LineChart chart = new LineChart(xAxis, yAxis);
		return chart;
	}
}
