package view;

import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class DropDownButtons extends HBox {
    private GridPane gridPane;
    public DropDownButtons() {
        addButtonGrid();

    }
    public void addButtonGrid () {
        gridPane = new GridPane();
        gridPane.add(createTitledPane("Controls"), 0, 0);
        gridPane.add(createTitledPane("Display"), 0, 2);
        RowConstraints top = new RowConstraints();
        top.setValignment(VPos.TOP);
        top.setPercentHeight(100.0 / 3.0);

        RowConstraints middle = new RowConstraints();
        middle.setValignment(VPos.CENTER);
        middle.setPercentHeight(100.0 / 3.0);

        RowConstraints bottom = new RowConstraints();
        bottom.setValignment(VPos.BOTTOM);
        bottom.setPercentHeight(100.0 / 3.0);

        gridPane.getRowConstraints().addAll(top, middle, bottom);

    }
    private TitledPane createTitledPane(String title) {
        TitledPane expandable = new TitledPane();
        expandable.setText(title);
        VBox content = new VBox(5);
        for (int i=1; i<=4; i++) {
            content.getChildren().add(new Label("Item "+i));
        }
        ScrollPane scroller = new ScrollPane();
        scroller.setContent(content);
        expandable.setContent(scroller);
        expandable.setExpanded(false);
        return expandable ;
    }
}
