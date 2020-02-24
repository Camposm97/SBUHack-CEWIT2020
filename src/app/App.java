package app;

import javafx.application.Application;
import javafx.stage.Stage;
import model.CoronaDatabase;
import util.KleisterParser;

public class App extends Application {
	public static final String TITLE = "Coronavirus Monitor";
	public static final CoronaDatabase DB = KleisterParser.importCoronaDB();
	
	@Override
	public void start(Stage stage) throws Exception {
		stage = new CoronaStage();
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
