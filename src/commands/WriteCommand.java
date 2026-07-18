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

        boolean success =
                context.getFileManager()
                        .writeFile(args[0], content.toString());

        if (success) {
            System.out.println("File saved successfully.");
        } else {
            System.out.println("Unable to write file.");
        }

        return true;
    }
}