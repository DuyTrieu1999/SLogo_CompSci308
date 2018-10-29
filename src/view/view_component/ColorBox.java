package view.view_component;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.*;

/**
 * ColorBox
 *
 * creates a ChoiceBox that allows user to specify a new color
 * for an object and returns the chosen color as a String
 *
 * @author brookekeene
 */
public class ColorBox extends ChoiceBox<String> {
    private static final String RESOURCE_PACKAGE = "text/view";
    private static final ArrayList<String> COLORS = new ArrayList<>(List.of(
            "White",
            "Red",
            "Orange",
            "Yellow",
            "Green",
            "Blue",
            "Purple",
            "Pink",
            "Brown",
            "Black"));
    private ResourceBundle myResources;

    /**
     * Constructor
     */
    ColorBox() {
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);
        this.getItems().addAll(COLORS);
    }

    /**
     * creates VBox that contains a Label and ColorBox itself
     * @return
     */
    VBox makeBox() {
        VBox colorControl = new VBox();
        Label colors = new Label(myResources.getString("ColorChoice"));
        colorControl.getChildren().addAll(colors, this);
        return colorControl;
    }

    /**
     *
     * @return String represented the color chosen by user
     */
    public String getColor() {
        return this.getValue();
    }
}
