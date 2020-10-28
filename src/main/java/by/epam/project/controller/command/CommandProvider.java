package by.epam.project.controller.command;


import by.epam.project.controller.command.impl.EmptyCommand;

/**
 * The type Command provider.
 */
public class CommandProvider {
    private CommandProvider() {
    }

    /**
     * Provide command command.
     *
     * @param command the command
     * @return the command
     */
    public static Command provideCommand(String command) {
        Command currentCommand;

        if (command == null || command.isEmpty()) {
            return new EmptyCommand();
        }
        try {
            currentCommand = CommandName.valueOf(command.toUpperCase()).getCommand();
        } catch (IllegalArgumentException exp) {
            currentCommand = new EmptyCommand();
        }
        return currentCommand;
    }
}
