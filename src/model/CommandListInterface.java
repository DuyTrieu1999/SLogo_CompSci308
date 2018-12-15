package model;

import java.util.*;

/**
 * This interface is for the front end to interact with the commandlist.
 * @author Yunhao Qing
 */

public interface CommandListInterface {

    /**
     * This method parse the text and execute the actions.
     * @param text the string to be parsed
     */
    void parse(String text);

    /**
     * This method set up the language
     * @param message the message
     */
    void setMessage (String message);

    /**
     * This method is used to set the language.
     * @param language
     */
    void setLanguage(ResourceBundle language);
}
