package view.view_component;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import java.util.ResourceBundle;

public class ImageChooser extends VBox{
    public static final int DROPDOWN_WIDTH = 200;
    public static final String DEFAULT_LABEL = "File Path";
    public static final String RESOURCE_PACKAGE = "text/view";
    private ResourceBundle myResources;
    private Button fileBtn;
    private Label fileName;
    private FileChooser myFC;

    public ImageChooser() {
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);

        myFC = new FileChooser();
        myFC.setTitle(myResources.getString("File"));
        Label chooser = new Label(myResources.getString("ImageChoice"));

        fileBtn = new Button(myResources.getString("File"));
        fileName = new Label(DEFAULT_LABEL);
        fileName.setWrapText(true);
        fileName.setMaxWidth(DROPDOWN_WIDTH);

        this.getChildren().addAll(chooser, fileName, fileBtn);
    }

    public Button getButton() {
        return fileBtn;
    }

    public FileChooser getFileChooser() {
        return myFC;
    }

    public void setFileName(String newLabel) {
        fileName.setText(newLabel);
    }
}
