package app;

import static util.ImgUtil.*;

import javafx.scene.Scene;
import javafx.stage.Stage;
import util.ImgUtil;
import view.CoronaPane;

public class CoronaStage extends Stage {
    private CoronaPane root;

    public CoronaStage() {
        this.root = new CoronaPane();
        this.setTitle(App.TITLE);
        this.getIcons().add(loadImg(APP_ICO));
        this.setScene(new Scene(root));
    }
}
