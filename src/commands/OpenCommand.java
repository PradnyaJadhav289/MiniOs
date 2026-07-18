package commands;

import command.CommandContext;

public class OpenCommand implements Command {
    @Override
    public boolean execute(CommandContext context) {
        String[] arguments = context.getArguments();
        if (arguments.length == 0) {
            System.out.println("Usage: open <file>");
            return true;
        }
        String filename = arguments[0];
        String opened= context.getFileManager().openFile(filename);

        if (opened != null) {
            System.out.println("File opened successfully.");
        } else {
            System.out.println("File not found.");
        }
        return true;
    }
}
