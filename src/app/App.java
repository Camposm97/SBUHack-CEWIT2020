package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.MyMenuBar;

public class App extends Application {
	public static final String TITLE = "Coronavirus Tracker";
	private BorderPane root;
	private MyMenuBar menuBar;
	
	@Override
	public void start(Stage stage) throws Exception {
		root = new BorderPane();
		menuBar = new MyMenuBar(root);
		root.setTop(menuBar);
		stage.setTitle(TITLE);
		stage.setScene(new Scene(root, 800, 600));
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
