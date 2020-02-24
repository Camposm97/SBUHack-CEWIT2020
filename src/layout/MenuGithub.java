package layout;

import static util.CamposWeb.*;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import util.ImgUtil;

public class MenuGithub extends Menu {
	private MenuItem miMichaelGH, miKieferGH, miChrisGH, miJonathanGH;
	
	public MenuGithub() {
		super("Developer's Github");
		initMenus();
		this.getItems().addAll(miMichaelGH, miKieferGH, miChrisGH, miJonathanGH);
	}
	
	private void initMenus() {
		miMichaelGH = new MenuItem("Michael's GitHub");
		miMichaelGH.setGraphic(ImgUtil.loadImgVScale(ImgUtil.MIKE_ICO, 30,30 ));
		miKieferGH = new MenuItem("Kiefer's GitHub");
		miKieferGH.setGraphic(ImgUtil.loadImgVScale(ImgUtil.KIEFER_ICO, 40, 40));
		miChrisGH = new MenuItem("Chris' GitHub");
		miChrisGH.setGraphic(ImgUtil.loadImgVScale(ImgUtil.CHRIS_ICO, 30, 30));
		miJonathanGH = new MenuItem("Jonathan's GitHub");
		miJonathanGH.setGraphic(ImgUtil.loadImgVScale(ImgUtil.JOHN_ICO, 30, 30));
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
