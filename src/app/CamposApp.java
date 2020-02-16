package app;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
import model.CoronaData;
import model.CoronaDatabase;
import util.CamposUtils;
import util.DataParser;
import view.CoronaDeathSearchPane;

@Deprecated
public class CamposApp extends Application {
	private static CoronaDatabase db;

	@Override
	public void start(Stage stage) throws Exception {
		CoronaDeathSearchPane root = new CoronaDeathSearchPane(db.getCoronaDeaths());
		stage.setScene(new Scene(root));
		stage.show();
	}
	
	public StackPane getLineGraph() {
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Day");
		yAxis.setLabel("Death Count");
		LineChart<Number, Number> lc = new LineChart<>(xAxis, yAxis);
		List<CoronaData> list = db.getCoronaDeaths();
		for (CoronaData c : list) {
			LinkedList<Integer> countList = c.getCountList();
			XYChart.Series<Number, Number> series = new XYChart.Series<>();
			series.setName(c.getProvinceOrState());
			
			for (int i = 0; i < countList.size(); i++) {
				series.getData().add(new Data<Number, Number>(i, countList.get(i)));
			}
			lc.getData().add(series);
			break;
		}
		lc.setTitle("Days vs. Death Count");
//		lc.setOnContextMenuRequested(e1 -> {
//			System.out.println("Hello World!");
//			ContextMenu cm = new ContextMenu();
//			MenuItem miSave = new MenuItem("Save Graph");
//			miSave.setOnAction(e2 -> {
//				CamposUtils.saveGraph(lc);
//			});
//			cm.getItems().addAll(miSave);
//			cm.show(stage);
//		});
		StackPane root = new StackPane(lc);
		return root;
	}

	public static void main(String[] args) throws IOException {
		db = DataParser.importCorona();
		launch();
	}
}
