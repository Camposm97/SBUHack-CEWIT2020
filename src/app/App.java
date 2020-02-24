package app;

import javafx.application.Application;
import javafx.stage.Stage;
import layout.CoronaStage;
import model.CoronaDatabase;
import util.KleisterParser;

/**
 * TODO:
 * When viewing the corona virus, there should ONLY one table that displays the
 * latest deaths, confirmed, and recoverd making it easier for the user to see
 * the statistics instead of clicking around in the menu bar.
 * (If implemented, then modify the context menu.)
 *
 * Instead of scraping the data all the time, there should an online or local
 * SQL database to the store the data.  If we go with the online one.  Then
 * there should be an option to update the database (ONLY FOR DEVELOPER).
 *
 * The user should have the option to view multiple series of data instead of
 * one on the line graph.  Perhaps have a context menu where the user can choose
 * to compare deaths to another location or compare deaths to confirmed of the
 * same location.  Maybe use mathematics in some way...
 *
 * The user should have the ability to view certain dates from date x to date y.
 * This will require to scrap the dates from the csv files that Kiefer did not
 * scrap.
 *
 * Maybe have the root display the global statistics of confirmed, deaths, and recovered.
 * Maybe in charts of the user choice.  Average the data and display.  Or ask the user
 * for his/her location to display the data of that location.  
 * @author Camposm
 */

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
