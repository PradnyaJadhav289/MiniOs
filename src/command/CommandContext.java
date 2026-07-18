package command;

import filesystem.FileManager;
import history.CommandHistory;
import java.util.Scanner;

public class CommandContext {
    private final String[] arguments;
    private final FileManager fileManager;
    private final CommandHistory history;
    private final Scanner scanner;
    
    public CommandContext(String[] arguments, FileManager fileManager, CommandHistory history, Scanner scanner) {
        this.arguments = arguments;
        this.fileManager = fileManager;
        this.history = history;
        this.scanner = scanner;
    }

    public String[] getArguments() {
        return arguments;
    }
    public FileManager getFileManager() {
        return fileManager;
    }
    public CommandHistory getHistory() {
        return history;
    }
    public Scanner getScanner() {
        return scanner;
    }
}
