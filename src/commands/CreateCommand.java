package commands;


import command.CommandContext;
import exceptions.InvalidCommandException;
import logger.Logger;

public class CreateCommand implements Command {

    @Override
    public boolean execute(CommandContext context) throws InvalidCommandException {
        // Implementation for create command
        String[] args = context.getArguments();
        if (args.length == 0) {
            Logger.Info("Usage: create <filename>");
            return true;
        }
        
            context.getFileManager().createFile(args[0]);
            Logger.Info("File created successfully.");
        
        return true;
    }

}
