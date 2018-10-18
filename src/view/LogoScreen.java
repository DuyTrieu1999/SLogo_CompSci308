package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ResourceBundle;

public class LogoScreen extends VBox {
    public static final String RESOURCE_PACKAGE = "resources/text/view";
    private ResourceBundle myResources;
    private GraphicsContext gc;
    private Canvas myCanvas;

    public LogoScreen () {
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);
        this.setId("main-screen");
        myCanvas = new Canvas();
        myCanvas.setWidth(Integer.parseInt(myResources.getString("Canvas_Width")));
        myCanvas.setHeight(Integer.parseInt(myResources.getString("Canvas_Height")));
        gc = myCanvas.getGraphicsContext2D();
        this.getChildren().add(myCanvas);
    }

    public void drawShapes(GraphicsContext gc) {
        gc.setStroke(Color.BLACK);
    }
}

