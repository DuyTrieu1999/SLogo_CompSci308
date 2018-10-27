package view.view_component;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * ColorBox
 *
 * @author brookekeene
 */
public class ColorBox extends ChoiceBox<String> {
    public static final String RESOURCE_PACKAGE = "text/view";
    public static final ArrayList<String> COLORS = new ArrayList<>(List.of(
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
    public ColorBox() {
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);
    }

    public VBox makeBox() {
        VBox colorControl = new VBox();
        Label colors = new Label(myResources.getString("Color"));
        this.getItems().addAll(COLORS);
        colorControl.getChildren().addAll(colors, this);
        return colorControl;
    }

    public String getColor() {
        String color = this.getValue();
        return color;
    }
}
