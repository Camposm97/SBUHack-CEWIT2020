package view;

import static util.CamposWeb.*;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class MenuGithub extends Menu {
	private MenuItem miMichaelGH, miKieferGH, miChrisGH, miJonathanGH;
	
	public MenuGithub() {
		super("Developer's Github");
		initMenus();
		this.getItems().addAll(miMichaelGH, miKieferGH, miChrisGH, miJonathanGH);
	}
	
	private void initMenus() {
		miMichaelGH = new MenuItem("Michael's GitHub");
		miKieferGH = new MenuItem("Kiefer's GitHub");
		miChrisGH = new MenuItem("Chris' GitHub");
		miJonathanGH = new MenuItem("Jonathan's GitHub");
		
		miMichaelGH.setOnAction(e -> {
			browse(GITHUB_MI);
		});

		miKieferGH.setOnAction(e -> {
			browse(GITHUB_KIEFER);
		});

		miChrisGH.setOnAction(e -> {
			browse(GITHUB_CHRIS);
		});

		miJonathanGH.setOnAction(e -> {
			browse(GITHUB_LEMUS);
		});
	}
}
