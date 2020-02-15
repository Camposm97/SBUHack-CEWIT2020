package view;

import app.App;
import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import util.AlertHelper;
import util.CamposWeb;

public class MyMenuBar extends MenuBar {
	private BorderPane root;
	private Menu menuFile, menuView, menuCorona, menuHelp, menuGithub;
	private MenuItem miExit, miCDC, miDonate, miSources, miAbout;

	public MyMenuBar(BorderPane root) {
		this.root = root;
		initControls();
		editControls();
		this.getMenus().addAll(menuFile, menuView, menuHelp);
	}

	private void initControls() {
		menuFile = new Menu("File");
		miExit = new MenuItem("Exit");
		menuView = new Menu("View");
		menuCorona = new MenuCorona(root);

		menuGithub = new MenuGithub();

		menuHelp = new Menu("Help");
		miCDC = new MenuItem("CDC");
		miDonate = new MenuItem("Donate");
		miSources = new MenuItem("Sources");
		miAbout = new MenuItem("About");
	}

	private void editControls() {
		

		miExit.setOnAction(e -> {
			Platform.exit();
		});

		miCDC.setOnAction(e -> {
			CamposWeb.browse(CamposWeb.URL_CDC);
		});

		miDonate.setOnAction(e -> {
			CamposWeb.browse(CamposWeb.URL_DONATE);
		});

		miSources.setOnAction(e -> {
			CamposWeb.browse(CamposWeb.URL_SOURCE);
		});

		miAbout.setOnAction(e -> {
			String content = "The purpose of this application is to track the corona virus.  Shows how effective it is at ending people.";
			AlertHelper.showInfo(App.TITLE, "About", content);
		});

		menuFile.getItems().add(miExit);
		menuView.getItems().addAll(menuCorona);
		menuHelp.getItems().addAll(menuGithub, miCDC, miSources, miDonate, miAbout);
	}

	

}
