package view;

public enum SceneENUM {
    SCENE_WIDTH(1300),
    SCENE_HEIGHT(600),
    BUTTON_GRID(240);

    double sceneVal;
    SceneENUM(double sceneVal) {
        this.sceneVal = sceneVal;
    }
    public double getVal() {
        return sceneVal;
    }
}
