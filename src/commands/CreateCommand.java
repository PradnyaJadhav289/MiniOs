package commands;

import java.io.IOException;

import command.CommandContext;
import exceptions.InvalidCommandException;

public class CreateCommand implements Command {

    @Override
    public boolean execute(CommandContext context) throws InvalidCommandException {
        // Implementation for create command
        String[] args = context.getArguments();
        if (args.length == 0) {
            System.out.println("Usage: create <filename>");

            return true;
        }
        try {
            context.getFileManager().createFile(args[0]);
            System.out.println("File created successfully.");
        } catch (IOException e) {
            throw new InvalidCommandException(e.getMessage());
        }
        return true;
    }

}
