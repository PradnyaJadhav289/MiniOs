package commands;

import terminal.Terminal;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        // Implementation for exit command
        Terminal.showexit();
    }
    
}
