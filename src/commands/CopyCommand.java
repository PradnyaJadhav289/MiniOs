package commands;

import command.CommandContext;

public class CopyCommand implements Command {

    @Override
    public boolean execute(CommandContext context) {

        String[] args = context.getArguments();

        if (args.length < 2) {
            System.out.println("Usage: copy <source> <destination>");
            return true;
        }
try{
        
                context.getFileManager()
                        .copyFile(args[0], args[1]);

        
            System.out.println("File copied successfully.");
        }
         catch (Exception e) {
            System.out.println("Unable to copy file: " + e.getMessage());
        }

        return true;
    }
}