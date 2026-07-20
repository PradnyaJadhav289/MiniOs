package commands;

import command.CommandContext;
import exceptions.InvalidCommandException;

public class CopyCommand implements Command {

    @Override
    public boolean execute(CommandContext context) throws InvalidCommandException {

        String[] args = context.getArguments();

        if (args.length < 2) {
            throw new InvalidCommandException("Usage: copy <source> <destination>");
        }
try{
        
                context.getFileManager()
                        .copyFile(args[0], args[1]);

        
            System.out.println("File copied successfully.");
        }
         catch (Exception e) {
            throw new InvalidCommandException(e.getMessage());
        }

        return true;
    }
}