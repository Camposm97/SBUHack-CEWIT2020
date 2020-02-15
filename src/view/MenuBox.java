package view;

import javafx.application.Platform;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MenuBox {
	private MenuBar menuBar;
	private Menu menuFile, menuView;
	private MenuItem miExit, miConfirmedCases, miDeaths, miRecoveries;
	private LineChart chart;
	
	public MenuBox(BorderPane pane) {
		menuBar = new MenuBar();
		
		menuFile = new Menu("File");
		miExit = new MenuItem("Exit");
		
		menuView = new Menu("View");
		miConfirmedCases = new MenuItem("Confirmed Cases");
		miDeaths = new MenuItem("Deaths");
		miRecoveries = new MenuItem("Recoveries");
		
		pane.setTop(this.getRoot());
		
		menuFile.getItems().add(miExit);
		menuView.getItems().addAll(miConfirmedCases, new SeparatorMenuItem(),
				miDeaths, new SeparatorMenuItem(),
				miRecoveries);
		
		menuBar.getMenus().addAll(menuFile, menuView);
		
		chart = makeChart();
		
		ConfirmedBox bigCBox = new ConfirmedBox(chart);
		VBox confirmedBox = bigCBox.getConfirmedBox();
		DeathBox bigDBox = new DeathBox();
		VBox deathBox = bigDBox.getDeathBox();
		RecoveryBox bigRBox = new RecoveryBox();
		VBox recoveryBox = bigRBox.getRecoveryBox();
		
		miExit.setOnAction(e -> {
			Platform.exit();
		});
		
		miConfirmedCases.setOnAction(e -> {
			pane.setCenter(confirmedBox);
		});
		
		miDeaths.setOnAction(e -> {
			pane.setCenter(deathBox);
		});
		
		miRecoveries.setOnAction(e -> {
			pane.setCenter(recoveryBox);
		});
	}
	
	public MenuBar getRoot() {
		return menuBar;
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
