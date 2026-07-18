package commands;
import command.CommandContext;
import terminal.Terminal;

public class ExitCommand implements Command {
    @Override
    public boolean execute(CommandContext context) {
        // Implementation for exit command
        Terminal.showexit();
        return true;
    }
    
}
