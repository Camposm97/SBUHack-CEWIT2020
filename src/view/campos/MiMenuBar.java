package view.campos;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

@Deprecated
public class MiMenuBar extends MenuBar {

	public MiMenuBar() {
		MenuItem miExit = new MenuItem("Exit");
		MenuItem miCorono = new MenuItem("Corono Virus");
		Menu miFile = new Menu("File");
		miFile.getItems().addAll(miExit);
		Menu miView = new Menu("View");
		miView.getItems().addAll(miCorono);
		this.getMenus().addAll(miFile, miView);
	}
}
