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
    private static final String RESOURCE_PACKAGE = "text/view";
    private ResourceBundle myResources;
    private HashMap<Integer, String> myColors;
    private int numDefault;

    /**
     * Constructor
     */
    public Palette() {
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);
        myColors = new HashMap<>();
        numDefault = Integer.parseInt(myResources.getString("NumColors"));
        this.addDefault();
    }

    /**
     * adds default colors from resource file to Palette
     */
    private void addDefault() {
        for(int i = 0; i < numDefault; i++) {
            String color = myResources.getString(Integer.toString(i));
            this.put(i, Color.valueOf(color));
            myColors.put(i, color);
        }
    }

    /**
     * adds new color to Palette
     * @param index
     * @param red
     * @param green
     * @param blue
     */
    public void addColor(int index, int red, int green, int blue) {
        if(this.containsKey(index)) {
            return;
        }
        Color newColor = Color.rgb(red, green, blue);
        this.put(index, newColor);
        String color = red + " " + green + " " + blue;
        myColors.put(index, color);
    }

    /**
     * returns HashMap of indexes and colors as Strings
     * @return
     */
    HashMap getColorMap() {
        return myColors;
    }
}
