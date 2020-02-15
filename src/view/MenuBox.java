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
	private MenuItem exitMenuItem;
	private MenuItem confirmedCasesItem;
	private MenuItem deathsItem;
	private MenuItem recoveriesItem;
	private LineChart chart;
	
	public MenuBox(BorderPane pane) {
		menuBar = new MenuBar();
		menuBar.prefWidthProperty().bind(pane.widthProperty());
		
		Menu fileMenu = new Menu("File");
		MenuItem exitMenuItem = new MenuItem("Exit");
		
		Menu viewMenu = new Menu("View");
		confirmedCasesItem = new MenuItem("Confirmed Cases");
		deathsItem = new MenuItem("Deaths");
		recoveriesItem = new MenuItem("Recoveries");
		
		pane.setTop(this.getMenuBar());
		
		fileMenu.getItems().add(exitMenuItem);
		viewMenu.getItems().addAll(confirmedCasesItem, new SeparatorMenuItem(),
				deathsItem, new SeparatorMenuItem(),
				recoveriesItem);
		
		menuBar.getMenus().addAll(fileMenu, viewMenu);
		
		chart = makeChart();
		
		ConfirmedBox bigCBox = new ConfirmedBox(chart);
		VBox confirmedBox = bigCBox.getConfirmedBox();
		DeathBox bigDBox = new DeathBox();
		VBox deathBox = bigDBox.getDeathBox();
		RecoveryBox bigRBox = new RecoveryBox();
		VBox recoveryBox = bigRBox.getRecoveryBox();
		
		exitMenuItem.setOnAction(e -> {
			Platform.exit();
		});
		
		confirmedCasesItem.setOnAction(e -> {
			pane.setCenter(confirmedBox);
		});
		
		deathsItem.setOnAction(e -> {
			pane.setCenter(deathBox);
		});
		
		recoveriesItem.setOnAction(e -> {
			pane.setCenter(recoveryBox);
		});
	}
	
	public MenuBar getMenuBar() {
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
