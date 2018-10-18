package model;

import java.util.*;

public class VariableMap {

    private Map<String, Integer> varMap;

    public VariableMap(){
        varMap = new HashMap<String, Integer>();
    }

    public void addVarible(String str, int i){
        varMap.put(str,i);
    }

    public Map<String, Integer> getVariables(){
        return varMap;
    }

    public int getVariable(String str){
        return varMap.get(str);
    }

    public void clearVariables(){
        varMap = new HashMap<String, Integer>();
        varMap = new HashMap<String, Integer>();
    }
}
