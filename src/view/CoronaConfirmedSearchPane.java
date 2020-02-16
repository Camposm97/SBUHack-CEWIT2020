package view;

import java.awt.MouseInfo;
import java.util.List;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import model.CoronaData;

public class CoronaConfirmedSearchPane extends BorderPane {
	private List<CoronaData> coronaConfimedList;
	private TableView<CoronaData> tv;
	
	public CoronaConfirmedSearchPane(List<CoronaData> coronaDeathList) {
		this.coronaConfimedList = coronaDeathList;
		initTableView();
		super.setCenter(tv);
	}
	
	private void initTableView() {
		tv = new TableView<>();
		initTableColumns();
		tv.setOnContextMenuRequested(e -> {
			CoronaData cd = tv.getSelectionModel().getSelectedItem();
			if (cd != null) {
				showContextMenu();
			}
		});
		tv.getItems().setAll(coronaConfimedList);
	}
	
	public void initTableColumns() {
		final String STYLE = "-fx-alignment: CENTER;";
		TableColumn<CoronaData, String> colState = new TableColumn<>("Province/State");
		colState.setCellValueFactory(new PropertyValueFactory<CoronaData, String>("provinceOrState"));
		colState.setStyle(STYLE);

		TableColumn<CoronaData, String> colCountry = new TableColumn<>("Country/Region");
		colCountry.setCellValueFactory(new PropertyValueFactory<CoronaData, String>("countryOrRegion"));
		colCountry.setStyle(STYLE);

		TableColumn<CoronaData, String> colLatestConfirmedCount = new TableColumn<>("Latest Confirmed Cases Count");
		colLatestConfirmedCount.setCellValueFactory(new PropertyValueFactory<CoronaData, String>("latestCount"));
		colLatestConfirmedCount.setStyle(STYLE);

		tv.getColumns().add(colState);
		tv.getColumns().add(colCountry);
		tv.getColumns().add(colLatestConfirmedCount);
	}
	
	private void showContextMenu() {
		CoronaData cd = tv.getSelectionModel().getSelectedItem();
		ContextMenu cm = new ContextMenu();
		MenuItem mi1 = new MenuItem("View Timeline");
		mi1.setOnAction(e -> {
			CoronaLineChartBox box = new CoronaLineChartBox(cd, "Timeline of Confirmed Cases", "Confirmed Cases");
			BorderPane root = (BorderPane) this.getParent();
			root.setCenter(box.getRoot());
		});
		cm.getItems().addAll(mi1);
		double x = MouseInfo.getPointerInfo().getLocation().getX();
		double y = MouseInfo.getPointerInfo().getLocation().getY();
		cm.show(getScene().getWindow(), x, y);
	}
}
