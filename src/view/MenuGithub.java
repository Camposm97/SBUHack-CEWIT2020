package view;

import static util.CamposWeb.*;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import util.ImgUtil;

public class MenuGithub extends Menu {
	private MenuItem miMichaelGH, miKieferGH, miJonathanGH;
	
	public MenuGithub() {
		super("Developer's Github");
		initMenus();
		this.getItems().addAll(miMichaelGH, miKieferGH, miJonathanGH);
	}
	
	private void initMenus() {
		miMichaelGH = new MenuItem("Michael's GitHub");
		miMichaelGH.setGraphic(ImgUtil.loadImgVScale(ImgUtil.MIKE_ICO, 24, 24));
		miKieferGH = new MenuItem("Kiefer's GitHub");
<<<<<<< HEAD
=======
		miKieferGH.setGraphic(ImgUtil.loadImgVScale(ImgUtil.KIEFER_ICO, 40, 40));
		miChrisGH = new MenuItem("Chris' GitHub");
>>>>>>> 40d64397013444d0b9ba149c40285e5f0cd82cf2
		miJonathanGH = new MenuItem("Jonathan's GitHub");
		miJonathanGH.setGraphic(ImgUtil.loadImgVScale(ImgUtil.JOHN_ICO, 24, 24));
		miMichaelGH.setOnAction(e -> {
			browse(GITHUB_MI);
		});
		this.setGraphic(ImgUtil.loadImgV(ImgUtil.GITHUB_ICO));
		miKieferGH.setOnAction(e -> {
			browse(GITHUB_KIEFER);
		});

		miJonathanGH.setOnAction(e -> {
			browse(GITHUB_LEMUS);
		});
	}
}
