package view;

import java.io.IOException;

import app.App;

import java.io.IOException;


import java.io.IOException;


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
	private MenuItem miConfirmedCases, miDeaths, miRecoveries, miTotals, miIndividualBarChart;
	private LineChart chartConfirmed, chartDeath, chartRecovery;
	
	public MenuCorona(BorderPane root) {
		super("Coronavirus");
		
		miConfirmedCases = new MenuItem("Confirmed Cases");
		miDeaths = new MenuItem("Deaths");
		miRecoveries = new MenuItem("Recoveries");
		miTotals= new MenuItem("Global Totals");
		miIndividualBarChart= new MenuItem("Individual Totals");
		
		chartConfirmed = makeChart();
		chartDeath = makeChart();
		chartRecovery = makeChart();

		TotalsBarSetup barSet = new TotalsBarSetup();
		TotalsBarSetup individualBarSet= new TotalsBarSetup();
		
		ConfirmedBox bigCBox = new ConfirmedBox(chartConfirmed);
		VBox confirmedBox = bigCBox.getConfirmedBox();
		DeathBox bigDBox = new DeathBox(chartDeath);
		VBox deathBox = bigDBox.getDeathBox();
		RecoveryBox bigRBox = new RecoveryBox(chartRecovery);
		VBox recoveryBox = bigRBox.getRecoveryBox();
		IndividualTotalBox iTB = new IndividualTotalBox(individualBarSet.getBarChart());
		TotalsBox bigTBox = new TotalsBox(barSet.getBarChart());
		HBox totalsBox = bigTBox.getTotalsBox();
		HBox individualTotalBox= iTB.getTotalsBox();
		
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
		miIndividualBarChart.setOnAction(e->{
			root.setCenter(individualTotalBox);
		});
		
		this.getItems().addAll(miConfirmedCases, miDeaths, miRecoveries, miTotals,miIndividualBarChart );
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
