package view.turtleView;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * @Author Duy Trieu
 */


public class TurtleInfo extends VBox {
    public TurtleInfo(TurtleDriver turtle) {
        addID(turtle);
        addPos(turtle);
        addHeading(turtle);
        addPenColor(turtle);
        addPenThickness(turtle);
        addPenUpDown(turtle);
    }
    private void addID (TurtleDriver turtle) {
        Label idText = new Label("ID: ");
        TextField idVal = new TextField(String.valueOf(turtle.getTurtleID()));
        VBox idBox = new VBox();
        idBox.getChildren().addAll(idText, idVal);
        this.getChildren().add(idBox);
    }
    private void addPos (TurtleDriver turtle) {
        Label positionText = new Label("Position: ");
        TextField positionVal = new TextField("X: " + String.format("%.2f", turtle.getX()) + " " + "Y: " + String.format("%.2f", turtle.getY()));
        VBox posBox = new VBox();
        posBox.getChildren().addAll(positionText, positionVal);
        this.getChildren().add(posBox);
    }
    private void addHeading (TurtleDriver turtle) {
        Label headingText = new Label("Heading: ");
        TextField headingVal = new TextField(String.format("%.2f", turtle.getOrientation()));
        VBox headingBox = new VBox();
        headingBox.getChildren().addAll(headingText, headingVal);
        this.getChildren().add(headingBox);
    }
    private void addPenColor (TurtleDriver turtle) {
        Label penColorText = new Label("Pen color: ");
        TextField penColorVal = new TextField(turtle.getPen().getColor().toString());
        VBox colorBox = new VBox();
        colorBox.getChildren().addAll(penColorText, penColorVal);
        this.getChildren().add(colorBox);
    }
    private void addPenThickness (TurtleDriver turtle) {
        Label penThicknessText = new Label("Pen thickness: ");
        TextField penThicknessVal = new TextField(String.format("%.2f", turtle.getPen().getThickness()));
        VBox thickBox = new VBox();
        thickBox.getChildren().addAll(penThicknessText, penThicknessVal);
        this.getChildren().add(thickBox);
    }
    private void addPenUpDown (TurtleDriver turtle) {
        Label penUpDownText = new Label("Pen is up/down: ");
        TextField penUpDownVal = new TextField(String.valueOf(turtle.getPen().isDown()));
        VBox updownBox = new VBox();
        updownBox.getChildren().addAll(penUpDownText, penUpDownVal);
        this.getChildren().add(updownBox);
    }
}
