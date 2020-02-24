package layout;

import java.awt.MouseInfo;
import java.util.List;

import app.App;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import model.CoronaData;
import util.CamposUtil;

public class CoronaDeathSearchPane extends BorderPane {
	private TextField tfSearch;
	private TableView<CoronaData> tv;
	
	public CoronaDeathSearchPane() {
		tfSearch = new TextField();
		tfSearch.setPromptText("Enter Locale Here");
		tfSearch.setOnAction(e -> {
			List<CoronaData> resultList = App.DB.searchDeathsByArea(tfSearch.getText());
			tv.getItems().setAll(resultList);
		});
		initTableView();
		super.setPadding(CamposUtil.DEFAULT_INSETS);
		super.setTop(tfSearch);
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
	}
	
	public void initTableColumns() {
		final double WIDTH = 248;
		final String STYLE = "-fx-alignment: CENTER;";
		TableColumn<CoronaData, String> colState = new TableColumn<>("Province/State");
		colState.setCellValueFactory(new PropertyValueFactory<CoronaData, String>("provinceOrState"));
		colState.setStyle(STYLE);
		colState.setPrefWidth(WIDTH);

		TableColumn<CoronaData, String> colCountry = new TableColumn<>("Country/Region");
		colCountry.setCellValueFactory(new PropertyValueFactory<CoronaData, String>("countryOrRegion"));
		colCountry.setStyle(STYLE);
		colCountry.setPrefWidth(WIDTH);

		
		TableColumn<CoronaData, String> colLatestDeathCount = new TableColumn<>("Latest Death Cases");
		colLatestDeathCount.setCellValueFactory(new PropertyValueFactory<CoronaData, String>("latestCount"));
		colLatestDeathCount.setStyle(STYLE);
		colLatestDeathCount.setPrefWidth(WIDTH);


		tv.getColumns().add(colState);
		tv.getColumns().add(colCountry);
		tv.getColumns().add(colLatestDeathCount);
	}
	
	private void showContextMenu() {
		CoronaData cd = tv.getSelectionModel().getSelectedItem();
		ContextMenu cm = new ContextMenu();
		MenuItem mi1 = new MenuItem("View Timeline");
		mi1.setOnAction(e -> {
			CoronaLineChartBox box = new CoronaLineChartBox(cd, "Timeline of Death Cases", "Death Cases");
			BorderPane root = (BorderPane) this.getParent();
			root.setCenter(box.getRoot());
		});
		cm.getItems().addAll(mi1);
		double x = MouseInfo.getPointerInfo().getLocation().getX();
		double y = MouseInfo.getPointerInfo().getLocation().getY();
		cm.show(getScene().getWindow(), x, y);
	}
	
}
