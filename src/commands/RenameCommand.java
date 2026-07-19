package commands;

import command.CommandContext;

public class RenameCommand implements Command {

    @Override
    public boolean execute(CommandContext context) {

        String[] args = context.getArguments();

        if (args.length < 2) {
            System.out.println("Usage: rename <oldfilename> <newfilename>");
            return true;
        }
try {
            context.getFileManager().renameFile(args[0], args[1]);
            System.out.println("File renamed successfully.");
        } catch (Exception e) {
            System.out.println("Error renaming file: " + e.getMessage());
        }
        
        
        return true;
    }
}