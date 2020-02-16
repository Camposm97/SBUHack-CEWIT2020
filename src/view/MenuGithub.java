package view;

import static util.CamposWeb.*;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class MenuGithub extends Menu {
	private MenuItem miMichaelGH, miKieferGH, miJonathanGH;
	
	public MenuGithub() {
		super("Developer's Github");
		initMenus();
		this.getItems().addAll(miMichaelGH, miKieferGH, miJonathanGH);
	}
	
	private void initMenus() {
		miMichaelGH = new MenuItem("Michael's GitHub");
		miKieferGH = new MenuItem("Kiefer's GitHub");
		miJonathanGH = new MenuItem("Jonathan's GitHub");
		
		miMichaelGH.setOnAction(e -> {
			browse(GITHUB_MI);
		});

		miKieferGH.setOnAction(e -> {
			browse(GITHUB_KIEFER);
		});

		miJonathanGH.setOnAction(e -> {
			browse(GITHUB_LEMUS);
		});
	}
}
