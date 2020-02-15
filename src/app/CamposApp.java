package app;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.CoronaDatabase;
import util.CamposUtils;
import util.DataParser;

public class CamposApp extends Application {
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void init() {
		try {
			CoronaDatabase coronaDb = DataParser.importCorona();
			coronaDb.display();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("X Axis");
		yAxis.setLabel("Y Axis");
		LineChart<Number, Number> lc = new LineChart<>(xAxis, yAxis);
		lc.setTitle("A Line Graph");
		XYChart.Series<Number, Number> series = new XYChart.Series<>();
		series.setName("Mine");
		// populating the series with data
		series.getData().add(new Data<Number, Number>(1, 23));
		series.getData().add(new Data<Number, Number>(2, 14));
		series.getData().add(new Data<Number, Number>(3, 15));
		series.getData().add(new Data<Number, Number>(4, 24));
		series.getData().add(new Data<Number, Number>(5, 34));
		series.getData().add(new Data<Number, Number>(6, 36));
		series.getData().add(new Data<Number, Number>(7, 22));
		series.getData().add(new Data<Number, Number>(8, 45));
		series.getData().add(new Data<Number, Number>(9, 43));
		series.getData().add(new Data<Number, Number>(10, 17));
		series.getData().add(new Data<Number, Number>(11, 29));
		series.getData().add(new Data<Number, Number>(12, 25));
		
		lc.getData().add(series);
		lc.setOnContextMenuRequested(e1 -> {
			System.out.println("Hello World!");
			ContextMenu cm = new ContextMenu();
			MenuItem miSave = new MenuItem("Save Graph");
			miSave.setOnAction(e2 -> {
				CamposUtils.saveGraph(lc);
			});
			cm.getItems().addAll(miSave);
			cm.show(stage);
		});
		StackPane root = new StackPane(lc);
		stage.setScene(new Scene(root));
		stage.show();
	}
}
