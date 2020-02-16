package view;

import java.util.List;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import model.CoronaData;

public class CoronaDeathSearchPane extends StackPane {
	private List<CoronaData> deathList;
	private TableView<CoronaData> tv;
	
	public CoronaDeathSearchPane(List<CoronaData> deathList) {
		this.deathList = deathList;
		initTableView();
	}
	
	private void initTableView() {
		tv = new TableView<>();
		initTableColumns();
		tv.setOnContextMenuRequested(e -> {
			CoronaData cd = tv.getSelectionModel().getSelectedItem();
			if (cd != null) {
//				showContextMenu();
			}
		});
		tv.getItems().setAll(deathList);
	}
	
	public void initTableColumns() {
		final String STYLE = "-fx-alignment: CENTER;";
		TableColumn<CoronaData, String> colState = new TableColumn<>("Province/State");
		colState.setCellValueFactory(new PropertyValueFactory<CoronaData, String>("provinceOrState"));
		colState.setStyle(STYLE);

		TableColumn<CoronaData, String> colCountry = new TableColumn<>("Country/Region");
		colCountry.setCellValueFactory(new PropertyValueFactory<CoronaData, String>("countryOrRegion"));
		colCountry.setCellFactory(TextFieldTableCell.forTableColumn());
		colCountry.setStyle(STYLE);

		TableColumn<CoronaData, String> colDeathCount = new TableColumn<>("Latest Death Count");
		colDeathCount.setCellValueFactory(new PropertyValueFactory<CoronaData, String>("firstName"));
//		colFirstName.setPrefWidth(WIDTH * 0.2);
		colDeathCount.setStyle(STYLE);

		tv.getColumns().add(colState);
		tv.getColumns().add(colCountry);
		tv.getColumns().add(colDeathCount);
	}
	
}
