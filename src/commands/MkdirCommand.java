package commands;

import command.CommandContext;

public class MkdirCommand implements Command {

    @Override
    public boolean execute(CommandContext context) {

        String[] args = context.getArguments();

        if (args.length != 1) {
            System.out.println("Usage: mkdir <directory_name>");
            return true;
        }

        context.getFileManager().mkdir(args[0]);

        System.out.println("Directory created successfully.");
        return true;
    }
}