package commands;

import command.CommandContext;
import exceptions.InvalidCommandException;

public class WriteCommand implements Command {

    @Override
    public boolean execute(CommandContext context) throws InvalidCommandException {

        String[] args = context.getArguments();

        if (args.length == 0) {
            throw new InvalidCommandException("Usage: write <filename>");
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
            throw new InvalidCommandException(e.getMessage());
        }

        System.out.println("File saved successfully.");

        return true;
    }
}