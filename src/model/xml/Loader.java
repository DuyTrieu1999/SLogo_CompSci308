package model.xml;

import java.util.List;
import java.util.Map;

public class Loader {

    // name in data file that will indicate it represents data for this type of object
    public static final String DATA_TYPE = "SLogo";
    // field names expected to appear in data file holding values for this object
    // NOTE: simple way to create an immutable list
    public static final List<String> DATA_FIELDS = List.of(
            "command",
            "variables",
            "instructions"
    );

    // specific data values for this instance
    private String commandName;
    private String[] variables;
    private String commands;


    /**
     * Create game data from given data.
     */
    public Loader(String command, String[] vars, String instructions) {
        commandName = command;
        variables = vars;
        commands = instructions;
    }

    /**
     * Create game data from a data structure of Strings.
     *
     * @param dataValues map of field names to their values
     */
    public Loader(Map<String, String> dataValues) {
        this(dataValues.get(DATA_FIELDS.get(0)),
                dataValues.get(DATA_FIELDS.get(1)).split("\\s+"),
                dataValues.get(DATA_FIELDS.get(2)));
    }

    // provide getters, not setters
    public String getCommandName() {
        return commandName;
    }

    public String[] getVariables() {
        return variables;
    }

    public String getCommands() {
        return commands;
    }

}
