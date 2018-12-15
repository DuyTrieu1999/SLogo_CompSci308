package view.view_component;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import java.util.ResourceBundle;

/**
 * ImageChooser
 *
 * creates a VBox containing a FileChooser
 *
 * @author brookekeene
 */
public class ImageChooser extends VBox{
    private static final int DROPDOWN_WIDTH = 200;
    private static final String DEFAULT_LABEL = "File Path";
    private static final String RESOURCE_PACKAGE = "text/view";
    private Button fileBtn;
    private Label fileName;
    private FileChooser myFC;

    /**
     * Constructor
     */
    public ImageChooser() {
        ResourceBundle myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);

        myFC = new FileChooser();
        myFC.setTitle(myResources.getString("File"));
        Label chooserLbl = new Label(myResources.getString("ImageChoice"));

        fileBtn = new Button(myResources.getString("File"));
        fileName = new Label(DEFAULT_LABEL);
        fileName.setWrapText(true);
        fileName.setMaxWidth(DROPDOWN_WIDTH);

        this.getChildren().addAll(chooserLbl, fileName, fileBtn);
    }

    /**
     *
     * @return Button that opens the FileChooser
     */
    Button getButton() {
        return fileBtn;
    }

    /**
     *
     * @return FileChooser object to select image
     */
    public FileChooser getFileChooser() {
        return myFC;
    }

    /**
     * sets the Label to new file path
     * @param newLabel
     */
    public void setFileName(String newLabel) {
        fileName.setText(newLabel);
    }
}
