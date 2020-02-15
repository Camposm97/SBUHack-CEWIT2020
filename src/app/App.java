package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.MenuBox;

public class App extends Application {
	public static final String TITLE = "Corona Virus Tracker";
	private BorderPane root;
	private MenuBox menuBox;
	
	@Override
	public void start(Stage stage) throws Exception {
		root = new BorderPane();
		menuBox = new MenuBox(root);
		root.setTop(menuBox.getRoot());
		stage.setTitle(TITLE);
		stage.setScene(new Scene(root, 700, 600));
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
