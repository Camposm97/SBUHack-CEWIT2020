package view;

import javafx.scene.layout.BorderPane;

public class CoronaPane extends BorderPane {
    private MyMenuBar menuBar;

    public CoronaPane() {
        this.menuBar = new MyMenuBar(this);
        super.setTop(menuBar);
    }
}
