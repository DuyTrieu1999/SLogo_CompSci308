package view;

public enum SceneENUM {
    SCENE_WIDTH(1000),
    SCENE_HEIGHT(600),
    LOGO_SCREEN_WIDTH(500),
    LOGO_SCREEN_HEIGHT(550),
    BUTTON_PADDING(10),
    DROPDOWN_WIDTH(200),
    BUTTON_GRID(50);


    double sceneVal;
    SceneENUM(double sceneVal) {
        this.sceneVal = sceneVal;
    }
    public double getVal() {
        return sceneVal;
    }
}
