package model;

import view.view_component.Palette;

import java.util.*;

/**
 * This class contains map of user variables and Palette objects.
 * We use this class to store variables and retreive variable values.
 *
 * @author Yunhao Qing
 * @author Allen Qiu
 * @author Brooke Keene
 */
public class VariableMap {
    private Map<String, Double> varMap;
    private Palette myPalette;

    /**
     * Constructor
     */
    public VariableMap(){
        varMap = new HashMap<>();
        myPalette = new Palette();
    }

    /**
     * adds a new variable to the variable map, varMap
     * @param str The name of variable
     * @param d The value of variable
     */
    public void addVariable(String str, double d){
        if(contains(str)){
            varMap.replace(str, d);
        }
        else {
            varMap.put(str, d);
        }
    }

    /**
     * returns variable map
     * @return varMap
     */
    public Map<String, Double> getVariables(){
        return varMap;
    }

    /**
     * returns the variable associated with key
     * @param str key to search for
     * @return the valur of the key
     */
    public double getVariable(String str){
        return varMap.get(str);
    }

    /**
     * checks whether the variable map contains the key given
     * @param key The key to be checked
     * @return boolean value
     */
    public boolean contains (String key){
        return varMap.containsKey(key);
    }

    /**
     * returns the Palette object, managed through VariableMap
     * @return myPalette
     */
    public Palette getPalette() {
        return myPalette;
    }
}
