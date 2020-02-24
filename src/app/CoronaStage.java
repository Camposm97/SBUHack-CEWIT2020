package app;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.MyMenuBar;

public class CoronaStage extends Stage {
    private MyMenuBar menuBar;
    private BorderPane root;

    public CoronaStage() {
        this.root = new BorderPane();
        this.menuBar = new MyMenuBar(root);
        this.setTitle(App.TITLE);

    }
}
