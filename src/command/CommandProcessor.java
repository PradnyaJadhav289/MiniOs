package command;

import java.io.File;

import filesystem.FileManager;
import terminal.Terminal;

public class CommandProcessor {

    private final FileManager fileManager;

    public CommandProcessor(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public boolean execute(String input) {

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

        // Second word = argument (if present)
        String argument = "";

        if (parts.length > 1) {
            argument = parts[1];
        }

        switch (command) {

            case "help":
                Terminal.showhelp();
                break;

            case "about":
                Terminal.showabout();
                break;

            case "date":
                Terminal.showdate();
                break;

            case "time":
                Terminal.showtime();
                break;

            case "clear":
                Terminal.clearScreen();
                break;

            case "create":
                if (argument.isEmpty()) {
                    System.out.println("Usage : create <filename>");
                    break;
                }
                boolean created = fileManager.createFile(argument);
                if (created) {
                    System.out.println("File created successfully.");
                } else {
                    System.out.println("File already exists.");
                }
                break;
            case "open":
                if (argument.isEmpty()) {
                    System.out.println("Usage : open <filename>");
                    break;
                }
                String content = fileManager.openFile(argument);
                if (content == null) {
                    System.out.println("File not found.");
                } else {
                    System.out.println("File content:\n" + content);
                }
                break;
            case "list":
                File[] files = fileManager.listFiles();

                if (files == null || files.length == 0) {

                    System.out.println("Storage is empty.");

                    break;

                }

                System.out.println("Files");

                for (File file : files) {

                    System.out.println(file.getName());

                }

                break;
            case "exit":
                Terminal.showexit();
                return false;

            default:
                Terminal.unknownCommand();
        }

        return true;
    }
}