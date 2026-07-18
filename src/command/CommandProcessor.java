package command;

import commands.*;

import java.util.Arrays;
import java.util.Map;

import java.util.Scanner;
import filesystem.FileManager;
import history.CommandHistory;
import terminal.Terminal;

public class CommandProcessor<CommmondContext> {

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

    public boolean execute(String input) {
        history.addCommand(input); // Add command to history
        // Remove extra spaces
        input = input.trim();

        // Empty command
        if (input.isEmpty()) {
            return true;
        }

        // Split command into parts
        String[] parts = input.split("\\s+");

        // First word = command
        String command = parts[0].toLowerCase();

        // Arguments (if present)
        String[] arguments = Arrays.copyOfRange(parts, 1, parts.length);
        CommandContext context = new CommandContext(arguments, fileManager, history, scanner);
        Command cmd = commandMap.get(command);
        if (cmd != null) {
            cmd.execute(context);
            return true;
        }

        Terminal.unknownCommand();

        return true;
    }
}
