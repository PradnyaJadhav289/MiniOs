package commands;
import terminal.Terminal;
public class TimeCommand implements Command {
    @Override
    public void execute() {
        // Implementation for time command
        Terminal.showtime();
    }
}
