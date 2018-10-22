package view;

import view.turtleView.TurtleDriver;

import java.util.ResourceBundle;

/**
 *
 * @Author Duy Trieu
 */
public interface SLogoViewAPI {
    public void clearConsole();
    public void clearDisplay();
    public void showMessage(String text);
    public void clearHistory();
    public TurtleDriver getTurtle();
    public void setLanguage(String language);
}
