package view;

import app.App;
import javafx.application.Platform;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import util.AlertHelper;
import util.CamposWeb;

public class MyMenuBar extends MenuBar {
	private BorderPane root;
	private Menu menuFile, menuView, menuHelp, menuGithub;
	private MenuItem miExit, miConfirmedCases, miDeaths, miRecoveries;
	private MenuItem miCDC, miDonate, miSources, miAbout;
	private LineChart chartConfirmed, chartDeath, chartRecovery;

	public MyMenuBar(BorderPane root) {
		this.root = root;
		initControls();
		editControls();
		this.getMenus().addAll(menuFile, menuView, menuHelp);
	}

	private void initControls() {
		menuFile = new Menu("File");
		miExit = new MenuItem("Exit");
		menuView = new Menu("View");

		miConfirmedCases = new MenuItem("Confirmed Cases");
		miDeaths = new MenuItem("Deaths");
		miRecoveries = new MenuItem("Recoveries");
		menuGithub = new MenuGithub();

		menuHelp = new Menu("Help");
		miCDC = new MenuItem("CDC");
		miDonate = new MenuItem("Donate");
		miSources = new MenuItem("Sources");
		miAbout = new MenuItem("About");

		chartConfirmed = makeChart();
		chartDeath = makeChart();
		chartRecovery = makeChart();
	}

	private void editControls() {
		ConfirmedBox bigCBox = new ConfirmedBox(chartConfirmed);
		VBox confirmedBox = bigCBox.getConfirmedBox();
		DeathBox bigDBox = new DeathBox(chartDeath);
		VBox deathBox = bigDBox.getDeathBox();
		RecoveryBox bigRBox = new RecoveryBox(chartRecovery);
		VBox recoveryBox = bigRBox.getRecoveryBox();

		miExit.setOnAction(e -> {
			Platform.exit();
		});

		miConfirmedCases.setOnAction(e -> {
			root.setCenter(confirmedBox);
		});

		miDeaths.setOnAction(e -> {
			root.setCenter(deathBox);
		});

		miRecoveries.setOnAction(e -> {
			root.setCenter(recoveryBox);
		});

		miCDC.setOnAction(e -> {
			CamposWeb.browse(CamposWeb.URL_CDC);
		});

		miDonate.setOnAction(e -> {
			CamposWeb.browse(CamposWeb.URL_DONATE);
		});

		miSources.setOnAction(e -> {
			CamposWeb.browse(CamposWeb.URL_SOURCE);
		});

		miAbout.setOnAction(e -> {
			String content = "The purpose of this application is to track the corona virus.  Shows how effective it is at ending people.";
			AlertHelper.showInfo(App.TITLE, "About", content);
		});

		menuFile.getItems().add(miExit);
		menuView.getItems().addAll(miConfirmedCases, miDeaths, miRecoveries);
		menuHelp.getItems().addAll(menuGithub, miCDC, miSources, miDonate, miAbout);
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
