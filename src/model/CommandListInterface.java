package model;

import java.util.*;

/**
 * This interface is for the front end to interact with the commandlist.
 * @author Yunhao Qing
 */

public interface CommandListInterface {

    void parse(String text);

    void setMessage (String message);

    void setLanguage (ResourceBundle language);
}
