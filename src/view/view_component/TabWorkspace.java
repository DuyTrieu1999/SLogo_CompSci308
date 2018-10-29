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
    private static final double TOP_ANCHOR = 8.0;
    private static final double RIGHT_ANCHOR = 6.0;
    private static final double LEFT_ANCHOR = 1.0;

    private Group myRoot;
    private Scene myScene;
    private TabPane tabPane;
    private int workspaces = 0;
    private BorderPane bdPane;
    private ResourceBundle myResources;

    public TabWorkspace () {
        initVariable();
        addTab();
    }
    private void initVariable () {
        myRoot = new Group();
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);
        this.tabPane = new TabPane();
        bdPane = new BorderPane();
        LogoButton button = createButton();
        AnchorPane pane = new AnchorPane(tabPane, button);
        AnchorPane.setTopAnchor(button, TOP_ANCHOR);
        AnchorPane.setRightAnchor(button, RIGHT_ANCHOR);
        AnchorPane.setTopAnchor(tabPane, TOP_ANCHOR);
        AnchorPane.setRightAnchor(tabPane, RIGHT_ANCHOR);
        AnchorPane.setLeftAnchor(tabPane, LEFT_ANCHOR);
        AnchorPane.setBottomAnchor(tabPane, LEFT_ANCHOR);
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
        LogoButton newButton = new LogoButton("New", event -> addTab());
        return newButton;
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
