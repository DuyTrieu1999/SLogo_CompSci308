package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class LogoScreen extends VBox {
    private GraphicsContext gc;

    public LogoScreen () {
        this.setId("main-screen");

        Canvas myCanvas = new Canvas();
        myCanvas.setWidth(SceneENUM.LOGO_SCREEN_WIDTH.getVal());
        myCanvas.setHeight(SceneENUM.LOGO_SCREEN_HEIGHT.getVal());
        gc = myCanvas.getGraphicsContext2D();

        this.getChildren().add(myCanvas);
    }

    public void drawShapes(GraphicsContext gc) {
        gc.setStroke(Color.BLACK);
    }
}