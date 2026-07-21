package commands;

import command.CommandContext;
import exceptions.InvalidCommandException;
import logger.Logger;

public class RenameCommand implements Command {

    @Override
    public boolean execute(CommandContext context) throws InvalidCommandException {

        String[] args = context.getArguments();

        if (args.length < 2) {
            throw new InvalidCommandException("Usage: rename <oldfilename> <newfilename>");
        }
        context.getFileManager().renameFile(args[0], args[1]);
        Logger.Info("File renamed successfully.");

        return true;
    }
}