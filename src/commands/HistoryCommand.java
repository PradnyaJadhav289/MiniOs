package commands;

import command.CommandContext;
import logger.Logger;

public class HistoryCommand implements Command {

    @Override
    public boolean execute(CommandContext context) {

Logger.Info("Command History:");
        int index = 1;

        for (String cmd : context.getHistory().getHistory()) {

            Logger.Info(index+ "."+ cmd);

            index++;
        }

        return true;
    }
}