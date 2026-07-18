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

        boolean renamed =
                context.getFileManager()
                        .renameFile(args[0], args[1]);

        if (renamed) {
            System.out.println("File renamed successfully.");
        } else {
            System.out.println("Unable to rename file.");
        }

        return true;
    }
}