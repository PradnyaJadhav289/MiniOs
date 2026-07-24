package command;

import commands.*;
import exceptions.InvalidCommandException;

import java.util.Arrays;
import java.util.Map;

import java.util.Scanner;
// import java.util.logging.Logger;

import filesystem.FileManager;
import history.CommandHistory;
import logger.Logger;

public class CommandProcessor {

    private final Map<String, Command> commandMap;
    private final FileManager fileManager;
    private final CommandHistory history;
    private final Scanner scanner;

    public CommandProcessor(FileManager fileManager, CommandHistory history, Scanner scanner) {
        this.fileManager = fileManager;
        this.scanner = scanner;
        this.history = history;
        this.commandMap = CommandRegistry.registerCommands();
    }

    public boolean execute(String input) throws InvalidCommandException {

    input = input.trim();

    if (input.isEmpty()) {
        return true;
    }

    history.addCommand(input);

    String[] parts = input.split("\\s+");

    String command = parts[0].toLowerCase();
    String[] arguments = Arrays.copyOfRange(parts, 1, parts.length);

    if (command.equals("cd..")) {
        command = "cd";
        arguments = new String[]{".."};
    }

    Logger.debug("Executing command: " + command);

    CommandContext context =
            new CommandContext(arguments, fileManager, history, scanner);

    Command cmd = commandMap.get(command);

    if (cmd == null) {
        throw new InvalidCommandException("Unknown command: " + command);
    }

    cmd.execute(context);

    Logger.debug("Command executed successfully: " + command);

    return true;
}
}
