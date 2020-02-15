package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RecoveryBox {
	private VBox recoveryBox;
	private HBox box1;
	private Label title;

	public RecoveryBox() {
		recoveryBox = new VBox();
		recoveryBox.setAlignment(Pos.CENTER);

		title = new Label("Recoveries");
		title.setAlignment(Pos.CENTER);
		box1 = new HBox(30);
		box1.getChildren().add(title);
		recoveryBox.getChildren().addAll(box1);
	}

	public VBox getRecoveryBox() {
		return recoveryBox;
	}
}
