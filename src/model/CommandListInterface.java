package model;

import java.util.*;

/**
 * @Author Yunhao Qing
 */

public interface CommandListInterface {

    public void parse(String text);

    public void setLanguage (String language);

    public String getLanguage();

    public void setMessage (String message);
}
