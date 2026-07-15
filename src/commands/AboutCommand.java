package commands;
import terminal.Terminal;
public class AboutCommand implements Command {
    @Override
    public void execute() {
        // Implementation for about command
        Terminal.showabout();
    }
    
}
