package view.turtleView;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * @Author Duy Trieu
 */


public class TurtleInfo extends VBox {
    private TurtleDriver myTurtle;
    private TextField idVal;
    private TextField positionVal;
    private TextField headingVal;
    private TextField penColorVal;
    private TextField penThicknessVal;
    private TextField penUpDownVal;

    public TurtleInfo(TurtleDriver turtle) {
        myTurtle = turtle;
        addID(myTurtle);
        addPos(myTurtle);
        addHeading(myTurtle);
        addPenColor(myTurtle);
        addPenThickness(myTurtle);
        addPenUpDown(myTurtle);
    }
    private void addID (TurtleDriver turtle) {
        Label idText = new Label("ID: ");
        idVal = new TextField(String.valueOf(turtle.getTurtleID()));
        VBox idBox = new VBox();
        idBox.getChildren().addAll(idText, idVal);
        this.getChildren().add(idBox);
    }
    private void addPos (TurtleDriver turtle) {
        Label positionText = new Label("Position: ");
        positionVal = new TextField("X: " + String.format("%.2f", turtle.getX()) + " " + "Y: " + String.format("%.2f", turtle.getY()));
        VBox posBox = new VBox();
        posBox.getChildren().addAll(positionText, positionVal);
        this.getChildren().add(posBox);
    }
    private void addHeading (TurtleDriver turtle) {
        Label headingText = new Label("Heading: ");
        headingVal = new TextField(String.format("%.2f", turtle.getOrientation()));
        VBox headingBox = new VBox();
        headingBox.getChildren().addAll(headingText, headingVal);
        this.getChildren().add(headingBox);
    }
    private void addPenColor (TurtleDriver turtle) {
        Label penColorText = new Label("Pen color: ");
        penColorVal = new TextField(turtle.getPen().getColor().toString());
        VBox colorBox = new VBox();
        colorBox.getChildren().addAll(penColorText, penColorVal);
        this.getChildren().add(colorBox);
    }
    private void addPenThickness (TurtleDriver turtle) {
        Label penThicknessText = new Label("Pen thickness: ");
        penThicknessVal = new TextField(String.format("%.2f", turtle.getPen().getThickness()));
        VBox thickBox = new VBox();
        thickBox.getChildren().addAll(penThicknessText, penThicknessVal);
        this.getChildren().add(thickBox);
    }
    private void addPenUpDown (TurtleDriver turtle) {
        Label penUpDownText = new Label("Pen is up/down: ");
        penUpDownVal = new TextField(String.valueOf(turtle.getPen().isDown()));
        VBox updownBox = new VBox();
        updownBox.getChildren().addAll(penUpDownText, penUpDownVal);
        this.getChildren().add(updownBox);
    }
    public void updateInfo() {
        idVal.setText(String.valueOf(myTurtle.getTurtleID()));
        positionVal.setText("X: " + String.format("%.2f", myTurtle.getX()) + " " + "Y: " + String.format("%.2f", myTurtle.getY()));
        headingVal.setText(String.format("%.2f", myTurtle.getOrientation()));
        penColorVal.setText(myTurtle.getPen().getColor().toString());
        penThicknessVal.setText(String.format("%.2f", myTurtle.getPen().getThickness()));
        penUpDownVal.setText(String.valueOf(myTurtle.getPen().isDown()));
    }
}
