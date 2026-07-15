package commands;
import terminal.Terminal;
public class DateCommand implements Command {
    @Override
    public void execute() {
        // Implementation for date command
          Terminal.showdate();
    }
    
}
