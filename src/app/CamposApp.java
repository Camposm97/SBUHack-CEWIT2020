package app;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import model.CoronaDatabase;
import util.DataParser;

public class CamposApp extends Application {
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void init() {
		try {
			CoronaDatabase coronaDb = DataParser.importCorona();
			coronaDb.display();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		
	}
}
