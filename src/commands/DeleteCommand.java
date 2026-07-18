package commands;

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
        boolean deleted  = context.getFileManager().deleteFile(filename);
        if (deleted) {
            System.out.println("File deleted: " + filename);
        } else {
            System.out.println("Failed to delete file: " + filename);
        }
        return deleted;
    }
    
}
