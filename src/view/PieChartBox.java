package view;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class PieChartBox {
	private VBox pieChartBox;
	
	public PieChartBox() {
		pieChartBox = new VBox();
		pieChartBox.setAlignment(Pos.CENTER);
	}
	
	public VBox getPieChartBox() {
		return pieChartBox;
	}
}
