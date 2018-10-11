package view;

import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;

public class DropDownButton extends HBox {
    final Accordion accordion = new Accordion();
    private TitledPane[] titledPanes = new TitledPane[3];;
    public DropDownButton() {
        for (int i = 0; i < titledPanes.length; i++) {
            titledPanes[i] = new TitledPane();
            titledPanes[i].setText("One");
            titledPanes[i].setContent(new Button("Button"));
        }
        accordion.getPanes().addAll(titledPanes);
    }
}
