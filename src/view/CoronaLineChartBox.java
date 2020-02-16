package view;

import java.util.LinkedList;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import model.CoronaData;
import util.CamposUtils;

public class CoronaLineChartBox {
	private CoronaData cd;
	private LineChart<Number, Number> lc;

	public CoronaLineChartBox(CoronaData cd, String title, String yLbl) {
		this.cd = cd;
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Days");
		yAxis.setLabel(yLbl);
		lc = new LineChart<>(xAxis, yAxis);
		lc.setTitle(title + " in " + cd.getProvinceOrState());

		LinkedList<Integer> countList = cd.getCountList();
		XYChart.Series<Number, Number> series = new XYChart.Series<>();
		series.setName(cd.getCountryOrRegion());

		for (int i = 0; i < countList.size(); i++) {
			series.getData().add(new Data<Number, Number>(i, countList.get(i)));
		}
		lc.getData().add(series);
		lc.setOnContextMenuRequested(e -> {
			Stage stage = (Stage) lc.getScene().getWindow();
			ContextMenu cm = new ContextMenu();
			MenuItem mi = new MenuItem("Save Graph");
			mi.setOnAction(e1 -> {
				CamposUtils.saveGraph(lc);
			});
			cm.getItems().add(mi);
			cm.show(stage);
		});
	}

	public LineChart<Number, Number> getRoot() {
		return lc;
	}
}
