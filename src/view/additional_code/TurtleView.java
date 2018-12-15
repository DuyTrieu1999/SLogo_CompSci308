package view.additional_code;

import javafx.geometry.Point3D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import view.turtleView.TurtleDriver;
import view.view_component.ImageChooser;
import view.view_component.LogoScreen;

import java.io.File;

public class TurtleView extends HBox {
    private LogoScreen screen;
    private TurtleDriver turtle;

    public TurtleView (LogoScreen screen) {
        this.screen = screen;
        this.turtle = screen.getMyTurtle();
        setUpDisplay();
    }
    private void setUpDisplay () {
        ImageView turtleView = turtle.getView();
        turtleView.setRotationAxis(new Point3D(0, 0, -1));
        ImageChooser imageBox = new ImageChooser();
        this.getChildren().add(turtleView);
        turtleView.setOnMouseClicked(value -> {
            File file = imageBox.getFileChooser().showOpenDialog(getScene().getWindow());
            if(file.toString().contains(".png") || file.toString().contains(".jpeg")) {
                imageBox.setFileName(file.toString());
                Image myImage = new Image(file.toURI().toString());
                screen.getMyTurtle().getView().setImage(myImage);
                turtleView.setImage(myImage);
            }
        });
    }
}
