package model;

import java.util.*;

/**
 * @Author Yunhao Qing
 */

public interface CommandListInterface {

    public void parse(String text);

    public void setMessage (String message);

    public void setLanguage (ResourceBundle language);
}
