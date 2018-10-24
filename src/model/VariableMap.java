package model;

import java.util.*;

public class VariableMap {

    private Map<String, Double> varMap;

    public VariableMap(){
        varMap = new HashMap<String, Double>();
    }

    public void addVariable(String str, double d){
        if(contains(str)){
            varMap.replace(str, d);
        }
        else {
            varMap.put(str, d);
        }
    }

    public Map<String, Double> getVariables(){
        return varMap;
    }

    public double getVariable(String str){
        return varMap.get(str);
    }

    public void clearVariables(){
        varMap = new HashMap<String, Double>();
    }

    public boolean contains (String key){
        return varMap.containsKey(key);
    }
}
