package view.turtleView;

import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Graphic {
    private ImageView turtleView;
    private int turtleID;
    private static final double TURN_TIME_MS = 250;
    private static final double OPACITY_ACTIVE = 1.0;
    private static final double OPACITY_INACTIVE = 0.2;

    public Graphic (int id, Image image) {
        this.turtleID = id;
        this.turtleView = new ImageView(image);
        this.turtleView.setScaleY(-1);
        this.turtleView.setFitWidth(100);
        this.turtleView.setFitHeight(100);
    }
    protected ImageView getView() {
        return turtleView;
    }

    protected void setImage(String url) {
        turtleView.setImage(new Image(url));
    }

    protected int getIndex() {
        return turtleID;
    }

    protected void setIndex(int index) {
        turtleID = index;
    }
    protected boolean isVisible() {
        return turtleView.isVisible();
    }

    protected void setVisible(boolean visible) {
        turtleView.setVisible(visible);
    }

    public void setRotation (double degrees) {
        RotateTransition rotate = new RotateTransition(Duration.millis(TURN_TIME_MS));
        rotate.setToAngle((degrees - 90) % 360);
        new SequentialTransition(turtleView, rotate).play();
    }
    public void setImageInactive (boolean active) {
        if (active) {
            turtleView.setOpacity(OPACITY_ACTIVE);
        }
        turtleView.setOpacity(OPACITY_INACTIVE);
    }
}
