package app;

import java.util.Scanner;
import terminal.Terminal;
import filesystem.FileManager;
import command.CommandProcessor;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FileManager fileManager = new FileManager();
        fileManager.initialize();
        CommandProcessor processor = new CommandProcessor(fileManager);

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
