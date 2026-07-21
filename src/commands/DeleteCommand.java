package commands;


import command.CommandContext;
import exceptions.InvalidCommandException;
import logger.Logger;

public class DeleteCommand implements Command {
    @Override
    public boolean execute(CommandContext context) throws InvalidCommandException {
        // Implementation for delete command
        String[] args = context.getArguments();
        if (args.length == 0) {
            throw new InvalidCommandException("Usage: delete <filename>");
        }
        String filename = args[0];
        context.getFileManager().deleteFile(filename);
        Logger.Info("File deleted: " + filename);

        return true;
    }

}
