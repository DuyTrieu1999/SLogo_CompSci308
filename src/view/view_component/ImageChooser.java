package view.view_component;

import commands.Log;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import view.turtleView.TurtleDriver;

import java.io.File;
import java.util.ResourceBundle;

public class ImageChooser extends VBox{
    public static final int DROPDOWN_WIDTH = 200;
    public static final String RESOURCE_PACKAGE = "text/view";
    private ResourceBundle myResources;
    private File myFile;
    private LogoScreen myDisplay;

    public ImageChooser(LogoScreen ls) {
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);
        myDisplay = ls;
    }

    public void makeChooser() {
        Label files = new Label(myResources.getString("ImageChoice"));
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(myResources.getString("File"));

        Button fileBtn = new Button(myResources.getString("File"));
        Label fileName = new Label("File Path");
        fileName.setWrapText(true);
        fileName.setMaxWidth(DROPDOWN_WIDTH);

        fileBtn.setOnAction(value -> {
            File file = fileChooser.showOpenDialog(getScene().getWindow());
            //TODO: error check
            // saves File if no exceptions and File is not null
            if(file.toString().contains(".png") || file.toString().contains(".jpeg")) { //When got the input as XML file.
                myFile = file;
                fileName.setText(myFile.toString());
                Image fileImage = new Image(myFile.toURI().toString());
                //myDisplay.getMyTurtle().setTurtleImage(fileImage);
                for (TurtleDriver turtle: myDisplay.getMyTurtle()) {
                    turtle.setTurtleImage(fileImage);
                }
            }
        });

        this.getChildren().addAll(files, fileName, fileBtn);
    }
}
