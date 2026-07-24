package commands;

import command.CommandContext;

public class CdCommand implements Command {

    @Override
    public boolean execute(CommandContext context) {

        String[] args = context.getArguments();

        if (args.length != 1) {
            System.out.println("Usage: cd <directory_name>");
            return true;
        }

        boolean changed = context.getFileManager().cd(args[0]);

        if (!changed) {
            System.out.println("Directory not found.");
        }
        return true;
    }
}