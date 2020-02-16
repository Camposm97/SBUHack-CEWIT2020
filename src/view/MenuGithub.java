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
<<<<<<< HEAD
		miChrisGH = new MenuItem("Chris' GitHub");
=======
		miKieferGH.setGraphic(ImgUtil.loadImgVScale(ImgUtil.KIEFER_ICO, 40, 40));
//		miChrisGH = new MenuItem("Chris' GitHub");
>>>>>>> 17bc8509f287da158e94dedee91822e0069fa000
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
