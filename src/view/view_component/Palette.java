package view.view_component;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * Palette
 *
 * @author brookekeene
 */
public class Palette extends HashMap<Integer, Color> {
    public static final String RESOURCE_PACKAGE = "text/view";
    private ResourceBundle myResources;
    private HashMap<Integer, String> myColors;

    public Palette() {
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);
        myColors = new HashMap<>();
        this.addDefault();
    }

    private void addDefault() {
        int numDefault = Integer.parseInt(myResources.getString("NumColors"));
        for(int i = 0; i < numDefault; i++) {
            String color = myResources.getString(Integer.toString(i));
            this.put(i, Color.valueOf(color));
            myColors.put(i, color);
        }
    }

    public void addColor(int index, int red, int green, int blue) {
        Color newColor = Color.rgb(red, green, blue);
        this.put(index, newColor);
        String color = red + " " + green + " " + blue;
        myColors.put(index, color);
    }

    public HashMap getColorMap() {
        return myColors;
    }
}
