package view;

import java.io.IOException;

import app.App;
import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import util.AlertHelper;
import util.CamposWeb;
import util.ImgUtil;

public class MyMenuBar extends MenuBar {
	private BorderPane root;
	private Menu menuFile, menuView, menuCorona, menuHelp, menuGithub;
	private MenuItem miExit, miCDC, miDonate, miSources, miAbout;

	public MyMenuBar(BorderPane root) throws IOException {
		this.root = root;
		initControls();
		editControls();
		this.getMenus().addAll(menuFile, menuView, menuHelp);
	}

	private void initControls() throws IOException {
		menuFile = new Menu("File");
		miExit = new MenuItem("Exit");
		menuView = new Menu("View");
		menuCorona = new MenuCorona(root);
		miExit.setGraphic(ImgUtil.loadImgV(ImgUtil.EXIT_ICO));
		menuGithub = new MenuGithub();
		
		
		menuHelp = new Menu("Help");
		miCDC = new MenuItem("CDC");
		miCDC.setGraphic(ImgUtil.loadImgVScale(ImgUtil.CDC_ICO, 16, 16));
		miDonate = new MenuItem("Donate");
		miDonate.setGraphic(ImgUtil.loadImgVScale(ImgUtil.DONATE_ICO, 16, 16));
		miSources = new MenuItem("Sources");
		miSources.setGraphic(ImgUtil.loadImgVScale(ImgUtil.SOURCES_ICO, 16, 16));
		miAbout = new MenuItem("About");
		miAbout.setGraphic(ImgUtil.loadImgVScale(ImgUtil.ABOUT_ICO, 16, 16));
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
			String content = "The purpose of this application is to track the novel coronavirus COVID-19.  Shows how effective it is at ending people.";
			AlertHelper.showInfo(App.TITLE, "About", content);
		});

		menuFile.getItems().add(miExit);
		menuView.getItems().addAll(menuCorona);
		menuHelp.getItems().addAll(menuGithub, miCDC, miSources, miDonate, miAbout);
	}

	

}
