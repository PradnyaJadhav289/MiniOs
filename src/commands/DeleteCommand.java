package commands;

import java.io.IOException;

import command.CommandContext;

public class DeleteCommand implements Command {
    @Override
    public boolean execute(CommandContext context) {
        // Implementation for delete command
       String[] args = context.getArguments();
        if (args.length == 0 ) {
            System.out.println("Usage: delete <filename>");
            return true;
        }
        String filename = args[0];
        try{
            context.getFileManager().deleteFile(filename);
            System.out.println("File deleted: " + filename);
        } catch (IOException e) {
            System.out.println("Error deleting file: " + e.getMessage());
        }
        return true;
    }
    
}

       
