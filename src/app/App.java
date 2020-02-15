package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.MenuBox;
import javafx.scene.chart.LineChart;

public class App extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		BorderPane root = new BorderPane();
		MenuBox menuBox = new MenuBox(root);
		root.setTop(menuBox.getRoot());
		Scene scene = new Scene(root, 700, 600);
		stage.setTitle("Coronavirus Graphs");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
