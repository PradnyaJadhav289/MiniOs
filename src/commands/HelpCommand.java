package commands;

import terminal.Terminal;

public class HelpCommand implements Command{
    @Override
    public void execute() {
        // Implementation for help command
        Terminal.showhelp();
    }
}
