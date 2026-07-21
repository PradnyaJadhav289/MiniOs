package app;

import java.util.Scanner;
import terminal.Terminal;
import filesystem.FileManager;
import command.CommandProcessor;
import exceptions.InvalidCommandException;
import history.CommandHistory;
import logger.Logger;

public class Main {

    public static void main(String[] args) throws InvalidCommandException {

        Scanner scanner = new Scanner(System.in);
        FileManager fileManager = new FileManager();
        fileManager.initialize();
        CommandHistory history = new CommandHistory();
        CommandProcessor processor = new CommandProcessor(fileManager, history, scanner);

        Terminal.showwelcome();

        boolean running = true;
Logger.Info("MiniOS Started");
      while (running) {

Logger.Info(" JavaOS>");
    String input = scanner.nextLine();

    try {

        running = processor.execute(input);

    } catch (InvalidCommandException e) {

Logger.Error("Invalid command: " + e.getMessage());
    }
}

        scanner.close();
    }
}
