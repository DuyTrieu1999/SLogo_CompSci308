package view;

import view.TurtleView.TurtleDriver;

public interface SLogoViewAPI {
    public void clearConsole();
    public void clearDisplay();
    public void showMessage(String text);
    public void resetSetting();
    public void resetTurtle();
    public void clearHistory();
    public TurtleDriver getTurtle();
//    public ArrayList<String> getSelectedVars(); //TODO: change return type - don't yet know how we are storing variables
//    public String getHistory(); //TODO: change return type - don't yet know how we are storing history
}
