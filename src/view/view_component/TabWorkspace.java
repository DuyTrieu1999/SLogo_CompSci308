package view.view_component;

import controller.Controller;
import javafx.event.Event;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class TabWorkspace extends HBox {
    private TabPane tabPane;
    private int workspaces = 0;
    private Controller controller;

    public TabWorkspace (Controller controller) {
        this.tabPane = new TabPane();
        this.controller = controller;
        LogoButton button = createButton();
        AnchorPane pane = new AnchorPane(tabPane, button);
        AnchorPane.setTopAnchor(button, 8.0);
        AnchorPane.setRightAnchor(button, 5.0);
        AnchorPane.setTopAnchor(tabPane, 6.0);
        AnchorPane.setRightAnchor(tabPane, 1.0);
        AnchorPane.setLeftAnchor(tabPane, 1.0);
        AnchorPane.setBottomAnchor(tabPane, 1.0);
        this.getChildren().add(pane);
        addTab();
    }
    private LogoButton createButton() {
        LogoButton newButton = new LogoButton("New", event -> addTab());
        return newButton;
    }

    private void addTab() {
        workspaces ++;
        Tab tab = new Tab();
        tab.setContent(controller.setLogoScreenSupplier());
        tab.setOnCloseRequest(e -> handleClose(e, controller));
        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);
    }
    private void handleClose(Event e, Controller controller) {
        if (workspaces > 1) {
            workspaces--;
        } else {
            controller.getMessageConsumer("OneTabRequirement");
            e.consume();
        }
    }
}
