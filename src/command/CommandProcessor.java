package command;

import java.io.File;
import java.util.Scanner;
import filesystem.FileManager;
import terminal.Terminal;

public class CommandProcessor {

    private final FileManager fileManager;

    private final Scanner scanner;

    public CommandProcessor(FileManager fileManager, Scanner scanner) {
        this.fileManager = fileManager;
        this.scanner = scanner;
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

            case "write":

                if (argument.isEmpty()) {
                    System.out.println("Usage: write <filename>");
                    break;
                }

                System.out.println("Enter text (Type END on a new line to save):");

                StringBuilder content1 = new StringBuilder();

                while (true) {

                    String line = scanner.nextLine();

                    if (line.equalsIgnoreCase("END")) {
                        break;
                    }

                    content1.append(line).append(System.lineSeparator());
                }

                boolean success = fileManager.writeFile(argument, content1.toString());

                if (success) {
                    System.out.println("File saved successfully.");
                } else {
                    System.out.println("Unable to write file.");
                }

                break;
            
            
            case "delete":
                if (argument.isEmpty()) {
                    System.out.println("Usage: delete <filename>");
                    break;
                }
                boolean deleted =fileManager.deleteFile(argument);
                if (deleted){
                    System.out.println("File deleted successfully.");   
                }
                else{
                    System.out.println("File not found.");
                }
            
                case "exit":
                Terminal.showexit();
                return false;

            default:
                Terminal.unknownCommand();
        }

        return true;
    }
}