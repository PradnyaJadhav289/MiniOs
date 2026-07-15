package command;

import commands.*;
import java.util.HashMap;
import java.util.Map;

import java.io.File;
import java.util.Scanner;
import filesystem.FileManager;
import history.CommandHistory;
import terminal.Terminal;

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

        // Second word = argument (if present)
        String firstargument = "";
        String secondargument = "";

        if (parts.length > 1) {
            firstargument = parts[1];
        }
        if (parts.length > 2) {
            secondargument = parts[2];
        }



        Command cmd = commandMap.get(command);

        if (cmd != null) {
            cmd.execute();

            if (command.equals("exit")) {
                return false;
            }

            return true;
        }
        switch (command) {
            
            case "create":
                if (firstargument.isEmpty()) {
                    System.out.println("Usage : create <filename>");
                    break;
                }
                boolean created = fileManager.createFile(firstargument);
                if (created) {
                    System.out.println("File created successfully.");
                } else {
                    System.out.println("File already exists.");
                }
                break;

            case "open":
                if (firstargument.isEmpty()) {
                    System.out.println("Usage : open <filename>");
                    break;
                }
                String content = fileManager.openFile(firstargument);
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

                if (firstargument.isEmpty()) {
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

                boolean success = fileManager.writeFile(firstargument, content1.toString());

                if (success) {
                    System.out.println("File saved successfully.");
                } else {
                    System.out.println("Unable to write file.");
                }

                break;

            case "delete":
                if (firstargument.isEmpty()) {
                    System.out.println("Usage: delete <filename>");
                    break;
                }
                boolean deleted = fileManager.deleteFile(firstargument);
                if (deleted) {
                    System.out.println("File deleted successfully.");
                } else {
                    System.out.println("File not found.");
                }
                break;
            case "rename":
                if (firstargument.isEmpty() || secondargument.isEmpty()) {
                    System.out.println("Usage: rename <oldfilename> <newfilename>");
                    break;
                }
                boolean renamed = fileManager.renameFile(firstargument, secondargument);
                if (renamed) {
                    System.out.println("File renamed successfully.");
                } else {
                    System.out.println("Unable to rename file.");
                }
                break;

            case "copy":
                if (firstargument.isEmpty() || secondargument.isEmpty()) {
                    System.out.println("Usage: copy <sourcefilename> <destinationfilename>");
                    break;
                }
                boolean copied = fileManager.copyFile(firstargument, secondargument);
                if (copied) {
                    System.out.println("File copied successfully.");
                } else {
                    System.out.println("Unable to copy file.");
                }
                break;

            case "history":
                System.out.println("Command History:");
                int index = 1;
                for (String historyCommand : history.getHistory()) {
                    System.out.println(index + ". " + historyCommand);
                    index++;
                }
                break;
            

            default:
                Terminal.unknownCommand();
        }

        return true;
    }
}
