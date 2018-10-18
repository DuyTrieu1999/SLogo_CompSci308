package view;

import java.util.ArrayList;

public interface SLogoViewAPI {
    public void clearConsole();
    public void clearDisplay();
    public void showMessage(String text);
    public void resetSettings();
    public void resetTurtle();
    public ArrayList<String> getSelectedVars(); //TODO: change return type - don't yet know how we are storing variables
    public String getHistory(); //TODO: change return type - don't yet know how we are storing history
    public void clearHistory();
}
