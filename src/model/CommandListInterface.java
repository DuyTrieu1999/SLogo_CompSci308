package model;

import java.util.*;

/**
 * @Author Yunhao Qing
 */

public interface CommandListInterface {
    String getCommand();
    List<String> getCommands();

    public void setLanguage (String language);

    public String getLanguage();

    public void setMessage (String message);
}
