package scene.layout;

import app.App;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static util.ImgUtil.APP_ICO;
import static util.ImgUtil.loadImg;

public class CoronaStage extends Stage {
    private static final double WIDTH = 800, HEIGHT = 700;
    private CoronaPane root;

    public CoronaStage() {
        this.root = new CoronaPane();
        this.setTitle(App.TITLE);
        this.getIcons().add(loadImg(APP_ICO));
        this.setScene(new Scene(root, WIDTH, HEIGHT));
    }
}
