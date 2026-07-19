package commands;

import command.CommandContext;

public class WriteCommand implements Command {

    @Override
    public boolean execute(CommandContext context) {

        String[] args = context.getArguments();

        if (args.length == 0) {

            System.out.println("Usage: write <filename>");

            return true;
        }

        System.out.println("Enter text (Type END on a new line to save):");

        StringBuilder content = new StringBuilder();

        while (true) {

            String line = context.getScanner().nextLine();

            if (line.equalsIgnoreCase("END")) {
                break;
            }

            content.append(line)
                   .append(System.lineSeparator());
        }

    try{
                context.getFileManager()
                        .writeFile(args[0], content.toString());
        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        System.out.println("File saved successfully.");

        return true;
    }
}