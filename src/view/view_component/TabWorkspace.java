package view.view_component;

import controller.Controller;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import view.SLogoView;

import java.util.ResourceBundle;

/**
 * @Author Duy Trieu
 */

public class TabWorkspace {
    private static final Paint BACKGROUND = Color.WHITE;
    private static final String STYLESHEET = "default.css";
    private static final String RESOURCE_PACKAGE = "/text/view";

    private Group myRoot;
    private Scene myScene;
    private TabPane tabPane;
    private int workspaces = 0;
    private ResourceBundle myResources;

    public TabWorkspace () {
        initVariable();
        addTab();
    }
    private void initVariable () {
        myRoot = new Group();
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);
        this.tabPane = new TabPane();
        BorderPane bdPane = new BorderPane();
        LogoButton button = createButton();
        AnchorPane pane = new AnchorPane(tabPane, button);
        AnchorPane.setTopAnchor(button, 8.0);
        AnchorPane.setRightAnchor(button, 5.0);
        AnchorPane.setTopAnchor(tabPane, 6.0);
        AnchorPane.setRightAnchor(tabPane, 1.0);
        AnchorPane.setLeftAnchor(tabPane, 1.0);
        AnchorPane.setBottomAnchor(tabPane, 1.0);
        bdPane.setCenter(pane);
        myRoot.getChildren().add(bdPane);
        sceneInit();
    }
    private void sceneInit () {
        myScene = new Scene(myRoot, Integer.parseInt(myResources.getString("Scene_Width")),
                Integer.parseInt(myResources.getString("Scene_Height")), BACKGROUND);
        myScene.getStylesheets().add(STYLESHEET);
    }
    private LogoButton createButton() {
        return new LogoButton("New", event -> addTab());
    }

    private void addTab() {
        workspaces ++;
        SLogoView view = new SLogoView();
        Tab tab = new Tab();
        Controller controller = view.getMyController();
        tab.setContent(view);
        tab.setOnCloseRequest(e -> handleClose(e, controller));
        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);
    }
    private void handleClose(Event e, Controller controller) {
        if (workspaces > 1) {
            workspaces--;
        } else {
            controller.getMessageConsumer("One Tab is required");
            e.consume();
        }
    }
    public Scene getMyScene () {
        return myScene;
    }
}
