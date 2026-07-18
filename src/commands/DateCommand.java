package commands;
import command.CommandContext;
import terminal.Terminal;
public class DateCommand implements Command {
    @Override
    public boolean execute(CommandContext context) {
        // Implementation for date command
          Terminal.showdate();
        return true;
    }
    
}
