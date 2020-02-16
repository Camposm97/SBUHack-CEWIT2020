package view;

//<<<<<<< HEAD
//=======
import java.io.IOException;

//>>>>>>> 9ae94d5f6f68f5ac5eb20acfe2c9a5a1294ede75
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import util.ImgUtil;

public class MenuCorona extends Menu {
	private MenuItem miConfirmedCases, miDeaths, miRecoveries, miTotals;
	private LineChart chartConfirmed, chartDeath, chartRecovery;
	
	public MenuCorona(BorderPane root) {
		super("Coronavirus");
		
		miConfirmedCases = new MenuItem("Confirmed Cases");
		miDeaths = new MenuItem("Deaths");
		miRecoveries = new MenuItem("Recoveries");
		
		chartConfirmed = makeChart();
		chartDeath = makeChart();
		chartRecovery = makeChart();
//<<<<<<< HEAD
//		chartTotals = new BarChart(new NumberAxis("Days", 0, 0, 0), new NumberAxis("Cases", 0, 0, 0));
//=======
		CategoryAxis totalsx = new CategoryAxis();
		totalsx.setLabel("Region");
		NumberAxis totalsy = new NumberAxis();
		totalsy.setLabel("Cases");
		BarChart<String, Number> chartTotals = new BarChart<String, Number>(totalsx, totalsy);
//>>>>>>> 9ae94d5f6f68f5ac5eb20acfe2c9a5a1294ede75
		
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
