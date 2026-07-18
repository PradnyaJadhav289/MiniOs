package commands;
import command.CommandContext;
import terminal.Terminal;
public class TimeCommand implements Command {
    @Override
    public boolean execute(CommandContext context) {
        // Implementation for time command
        Terminal.showtime();
        return true;
    }
}
