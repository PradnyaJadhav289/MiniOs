package commands;
import command.CommandContext;
import terminal.Terminal;

public class ClearCommand  implements Command {
    @Override
    public boolean execute(CommandContext context) {
        // Implementation for clear command
        Terminal.clearScreen();
        return true;
    }
    
}
