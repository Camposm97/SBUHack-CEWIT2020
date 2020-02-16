package view;

import java.awt.MouseInfo;
import java.util.List;

import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import model.CoronaData;

public class CoronaDeathSearchPane extends BorderPane {
	private List<CoronaData> coronaDeathList;
	private TableView<CoronaData> tv;
	
	public CoronaDeathSearchPane(List<CoronaData> coronaDeathList) {
		this.coronaDeathList = coronaDeathList;
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
		tv.getItems().setAll(coronaDeathList);
	}
	
	public void initTableColumns() {
		final String STYLE = "-fx-alignment: CENTER;";
		TableColumn<CoronaData, String> colState = new TableColumn<>("Province/State");
		colState.setCellValueFactory(new PropertyValueFactory<CoronaData, String>("provinceOrState"));
		colState.setStyle(STYLE);

		TableColumn<CoronaData, String> colCountry = new TableColumn<>("Country/Region");
		colCountry.setCellValueFactory(new PropertyValueFactory<CoronaData, String>("countryOrRegion"));
		colCountry.setStyle(STYLE);

		TableColumn<CoronaData, String> colLatestDeathCount = new TableColumn<>("Latest Death Count");
		colLatestDeathCount.setCellValueFactory(new PropertyValueFactory<CoronaData, String>("latestCount"));
		colLatestDeathCount.setStyle(STYLE);

		tv.getColumns().add(colState);
		tv.getColumns().add(colCountry);
		tv.getColumns().add(colLatestDeathCount);
	}
	
	private void showContextMenu() {
		CoronaData cd = tv.getSelectionModel().getSelectedItem();
		ContextMenu cm = new ContextMenu();
	
//		cm.getItems().addAll(mi1, mi2);
		double x = MouseInfo.getPointerInfo().getLocation().getX();
		double y = MouseInfo.getPointerInfo().getLocation().getY();
		cm.show(getScene().getWindow(), x, y);
	}
	
}
