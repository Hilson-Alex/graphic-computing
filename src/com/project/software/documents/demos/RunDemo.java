package com.project.software.documents.demos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RunDemo {

    private Scanner scanner = new Scanner(System.in);

    private final String OPEN_PARENTHESES = "(";
    private final String CLOSE_PARENTHESES = ")";

    private final String VALUE = "value";
    private final String COMMAND = "command";

    private final String CLOSE_COMMAND = "exit";

    /**
     * Menu loop
     */
    public void run() {
        Boolean menuReturn;

        do {
            System.out.print("CG> : ");
            menuReturn = litemCommand();
        } while (menuReturn);
    }

    /**
     * Call calculate methods
     * @return boolean, control while
     */
    private boolean litemCommand() {

        String commandFull = scanner.nextLine();
        Map commandValue = extractValues(commandFull.replaceAll("\\s+",""));

        try {
            Demos.valueOf(((String) commandValue.get(COMMAND)).toUpperCase())
                    .exec();
        } catch (IllegalArgumentException exception) {
            System.out.println("Invalid Command, type \"help\" to show commands");
        }

        return !commandValue.get(COMMAND).equals(CLOSE_COMMAND);
    }


    private Map extractValues(String command) {
        var values = new HashMap<String, Object>();

        if (command.contains(OPEN_PARENTHESES)) {
            var indexStart = command.indexOf(OPEN_PARENTHESES);
            var indexEnd = command.indexOf(CLOSE_PARENTHESES);

            var valueString = command.substring(indexStart + 1, indexEnd);
            var commandString = command.substring(0, indexStart);

            values.put(VALUE, Integer.valueOf(valueString));
            values.put(COMMAND, commandString);;

            return values;
        }

        values.put(COMMAND, command);

        return values;
    }

}
