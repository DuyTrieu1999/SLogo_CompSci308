package model;

import java.util.*;

/**
 * @Author Yunhao Qing
 */

public interface CommandListInterface {

    void parse(String text);

    void setMessage (String message);

    void setLanguage(ResourceBundle language);
}
