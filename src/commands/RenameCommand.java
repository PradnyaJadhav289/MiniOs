package commands;

import command.CommandContext;
import exceptions.InvalidCommandException;

public class RenameCommand implements Command {

    @Override
    public boolean execute(CommandContext context) throws InvalidCommandException {

        String[] args = context.getArguments();

        if (args.length < 2) {
            throw new InvalidCommandException("Usage: rename <oldfilename> <newfilename>");
        }
try {
            context.getFileManager().renameFile(args[0], args[1]);
            System.out.println("File renamed successfully.");
        } catch (Exception e) {
            throw new InvalidCommandException(e.getMessage());
        }

        return true;
    }
}