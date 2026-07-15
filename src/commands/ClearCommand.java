package commands;

import terminal.Terminal;

public class ClearCommand  implements Command {
    @Override
    public void execute() {
        // Implementation for clear command
       Terminal.clearScreen();;
    }
    
}
