package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class LogoScreen extends Canvas {
    public LogoScreen () {
        this.setWidth(SceneENUM.LOGO_SCREEN_WIDTH.getVal());
        this.setHeight(SceneENUM.LOGO_SCREEN_HEIGHT.getVal());

        GraphicsContext gc = this.getGraphicsContext2D();
        drawShapes(gc);
    }
    public void drawShapes(GraphicsContext gc) {
        gc.setStroke(Color.BLACK);
        gc.stroke();
    }
}
