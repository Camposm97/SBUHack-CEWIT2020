package view;

import java.io.IOException;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import util.ImgUtil;

public class MenuCorona extends Menu {
	private MenuItem miConfirmedCases, miDeaths, miRecoveries, miTotals;
	private LineChart chartConfirmed, chartDeath, chartRecovery;
	private BarChart chartTotals;
	
	public MenuCorona(BorderPane root) throws IOException {
		super("Coronavirus");
		
		miConfirmedCases = new MenuItem("Confirmed Cases");
		miDeaths = new MenuItem("Deaths");
		miRecoveries = new MenuItem("Recoveries");
		
		chartConfirmed = makeChart();
		chartDeath = makeChart();
		chartRecovery = makeChart();
		NumberAxis totalsx = new NumberAxis();
		totalsx.setLabel("Days");
		NumberAxis totalsy = new NumberAxis();
		totalsy.setLabel("Cases");
		chartTotals = new BarChart(totalsx, totalsy);
		
		ConfirmedBox bigCBox = new ConfirmedBox(chartConfirmed);
		VBox confirmedBox = bigCBox.getConfirmedBox();
		DeathBox bigDBox = new DeathBox(chartDeath);
		VBox deathBox = bigDBox.getDeathBox();
		RecoveryBox bigRBox = new RecoveryBox(chartRecovery);
		VBox recoveryBox = bigRBox.getRecoveryBox();
		TotalsBox bigTBox = new TotalsBox(chartTotals);
		VBox totalsBox = bigTBox.getTotalsBox();
		
		miConfirmedCases.setOnAction(e -> {
			root.setCenter(confirmedBox);
		});

		miDeaths.setOnAction(e -> {
			root.setCenter(deathBox);
		});

		miRecoveries.setOnAction(e -> {
			root.setCenter(recoveryBox);
		});
		
		miTotals.setOnAction(e -> {
			root.setCenter(totalsBox);
		});
		this.getItems().addAll(miConfirmedCases, miDeaths, miRecoveries, miTotals);
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
