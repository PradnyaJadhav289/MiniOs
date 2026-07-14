package app;

import java.util.Scanner;
import terminal.Terminal;
import filesystem.FileManager;
import command.CommandProcessor;
import history.CommandHistory;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FileManager fileManager = new FileManager();
        fileManager.initialize();
        CommandHistory history = new CommandHistory();
        CommandProcessor processor = new CommandProcessor(fileManager, history, scanner);

        Terminal.showwelcome();

        boolean running = true;

        while (running) {

            System.out.print("JavaOS> ");
            String input = scanner.nextLine().trim();
            running = processor.execute(input);
        }

        scanner.close();
    }
}
