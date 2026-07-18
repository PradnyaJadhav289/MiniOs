package commands;
import command.CommandContext;
import terminal.Terminal;

public class HelpCommand implements Command{
    @Override
    public boolean execute(CommandContext context) {
        // Implementation for help command
        Terminal.showhelp();
        return true;
    }
}
