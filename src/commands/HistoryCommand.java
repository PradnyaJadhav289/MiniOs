package commands;

import command.CommandContext;

public class HistoryCommand implements Command {

    @Override
    public boolean execute(CommandContext context) {

        System.out.println("Command History:");

        int index = 1;

        for (String cmd : context.getHistory().getHistory()) {

            System.out.println(index + ". " + cmd);

            index++;
        }

        return true;
    }
}