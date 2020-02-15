package view;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import util.ImgUtil;

public class MenuCorona extends Menu {
	private MenuItem miConfirmedCases, miDeaths, miRecoveries;
	private LineChart chartConfirmed, chartDeath, chartRecovery;

	
	public MenuCorona(BorderPane root) {
		super("Coronavirus");
		
		miConfirmedCases = new MenuItem("Confirmed Cases");
		miDeaths = new MenuItem("Deaths");
		miRecoveries = new MenuItem("Recoveries");
		
		chartConfirmed = makeChart();
		chartDeath = makeChart();
		chartRecovery = makeChart();
		
		ConfirmedBox bigCBox = new ConfirmedBox(chartConfirmed);
		VBox confirmedBox = bigCBox.getConfirmedBox();
		DeathBox bigDBox = new DeathBox(chartDeath);
		VBox deathBox = bigDBox.getDeathBox();
		RecoveryBox bigRBox = new RecoveryBox(chartRecovery);
		VBox recoveryBox = bigRBox.getRecoveryBox();
		
		miConfirmedCases.setOnAction(e -> {
			root.setCenter(confirmedBox);
		});

		miDeaths.setOnAction(e -> {
			root.setCenter(deathBox);
		});

		miRecoveries.setOnAction(e -> {
			root.setCenter(recoveryBox);
		});
		this.getItems().addAll(miConfirmedCases, miDeaths, miRecoveries);
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
