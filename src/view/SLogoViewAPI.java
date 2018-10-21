package view;

import view.turtleView.TurtleDriver;

public interface SLogoViewAPI {
    public void clearConsole();
    public void clearDisplay();
    public void showMessage(String text);
    public void clearHistory();
    public TurtleDriver getTurtle();
}
