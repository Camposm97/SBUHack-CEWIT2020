package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DeathBox {
	private VBox deathBox;
	private HBox box1;
	private Label title;

	public DeathBox() {
		deathBox = new VBox();
		deathBox.setAlignment(Pos.CENTER);

		title = new Label("Deaths");
		title.setAlignment(Pos.CENTER);
		box1 = new HBox(30);
		box1.getChildren().add(title);
		deathBox.getChildren().addAll(box1);
	}

	public VBox getDeathBox() {
		return deathBox;
	}
}
