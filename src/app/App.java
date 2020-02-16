package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.CoronaDatabase;
import util.DataParser;
import view.MyMenuBar;

public class App extends Application {
	public static final String TITLE = "Coronavirus Monitor";
	public static final CoronaDatabase DB = DataParser.importCorona();
	private BorderPane root;
	private MyMenuBar menuBar;
	
	@Override
	public void start(Stage stage) throws Exception {
		root = new BorderPane();
		menuBar = new MyMenuBar(root);
		root.setTop(menuBar);
		stage.setTitle(TITLE);
		stage.setScene(new Scene(root, 700, 600));
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
