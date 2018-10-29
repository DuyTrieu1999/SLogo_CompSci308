package view.view_component;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ResourceBundle;

/**
 * TurtleDriver
 *
 * @author Duy Trieu
 */
public class TurtleButtonControl extends HBox {
    private static final String RESOURCE_PACKAGE = "/text/view";
    private static final int INSET_PADDING = 70;
    private static final int INSET_SIZE_PADDING = 10;

    private ResourceBundle myResources;

    public TurtleButtonControl (Controller myController) {
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);
        LogoButton upButton = new LogoButton(myResources.getString("Up"), e -> upFunction(myController));
        LogoButton downButton = new LogoButton(myResources.getString("Down"), e -> downFunction(myController));
        LogoButton leftButton = new LogoButton(myResources.getString("Left"), e -> leftFunction(myController));
        LogoButton rightButton = new LogoButton(myResources.getString("Right"), e -> rightFunction(myController));
        VBox upDownBox = new VBox();
        upDownBox.getChildren().addAll(upButton, downButton);
        this.getChildren().addAll(leftButton, upDownBox, rightButton);
        this.setPadding(new Insets(0, INSET_SIZE_PADDING, INSET_SIZE_PADDING, INSET_PADDING));
    }
    private void upFunction (Controller controller) {
        controller.setParseConsumer("fd 50");
    }
    private void downFunction (Controller controller) {
        controller.setParseConsumer("bk 50");
    }
    private void leftFunction (Controller controller) {
        controller.setParseConsumer("lt 90 fd 50");
    }
    private void rightFunction (Controller controller) {
        controller.setParseConsumer("rt 90 fd 50");
    }
}
