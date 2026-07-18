package commands;
import command.CommandContext;
import terminal.Terminal;
public class AboutCommand implements Command {
    @Override
    public boolean execute(CommandContext context) {
        // Implementation for about command
        Terminal.showabout();
        return true;
    }
    
}
