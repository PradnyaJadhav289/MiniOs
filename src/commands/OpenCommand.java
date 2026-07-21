package commands;


import command.CommandContext;
import exceptions.InvalidCommandException;
import logger.Logger;

public class OpenCommand implements Command {

    @Override
    public boolean execute(CommandContext context) throws InvalidCommandException {

        String[] arguments = context.getArguments();

        if (arguments.length == 0) {
            throw new InvalidCommandException("Usage: open <file>");
        }

        String text = context.getFileManager().openFile(arguments[0]);

        Logger.Info(text);

        return true;
    }
}