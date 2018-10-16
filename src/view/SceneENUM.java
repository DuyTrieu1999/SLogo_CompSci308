package view;

public enum SceneENUM {
    SCENE_WIDTH(1000),
    SCENE_HEIGHT(600),
    LOGO_SCREEN_WIDTH(450),
    LOGO_SCREEN_HEIGHT(550),
    TEXT_EDITOR_WIDTH(300),
    TEXT_EDITOR_HEIGHT(200),
    BUTTON_PADDING(5),
    DROPDOWN_WIDTH(200),
    BUTTON_GRID(70);


    double sceneVal;
    SceneENUM(double sceneVal) {
        this.sceneVal = sceneVal;
    }
    public double getVal() {
        return sceneVal;
    }
}
