package model;

import view.view_component.Palette;

import java.util.*;

/**
 * VariableMap
 *
 * contains map of user variables and Palette object
 *
 * @author
 * @author
 * @author brookekeene
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
     * @param str
     * @param d
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
     * @return
     */
    public double getVariable(String str){
        return varMap.get(str);
    }

    /**
     * checks whether the variable map contains the key given
     * @param key
     * @return
     */
    public boolean contains (String key){
        return varMap.containsKey(key);
    }

    /**
     * returns the Palette object, managed through VariableMap
     * @return
     */
    public Palette getPalette() {
        return myPalette;
    }
}
