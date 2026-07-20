package commands;

import java.io.IOException;

import command.CommandContext;
import exceptions.InvalidCommandException;

public class DeleteCommand implements Command {
    @Override
    public boolean execute(CommandContext context) throws InvalidCommandException {
        // Implementation for delete command
       String[] args = context.getArguments();
        if (args.length == 0 ) {
            throw new InvalidCommandException("Usage: delete <filename>");
        }
        String filename = args[0];
        try{
            context.getFileManager().deleteFile(filename);
            System.out.println("File deleted: " + filename);
        } catch (IOException e) {
            throw new InvalidCommandException(e.getMessage());
        }
        return true;
    }
    
}

       
