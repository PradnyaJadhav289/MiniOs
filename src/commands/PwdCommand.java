package commands;

import command.CommandContext;

public class PwdCommand implements Command {

    @Override
    public boolean execute(CommandContext context) {

        System.out.println(context.getFileManager().pwd());
        return true;

    }
}