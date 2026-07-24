package commands;

import command.CommandContext;

public class LsCommand implements Command {

    @Override
    public boolean execute(CommandContext context) {

        context.getFileManager().ls();
        return true;

    }
}