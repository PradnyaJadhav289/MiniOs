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

        boolean copied =
                context.getFileManager()
                        .copyFile(args[0], args[1]);

        if (copied) {
            System.out.println("File copied successfully.");
        } else {
            System.out.println("Unable to copy file.");
        }

        return true;
    }
}