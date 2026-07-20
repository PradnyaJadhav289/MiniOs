package commands;

import java.io.IOException;

import command.CommandContext;
import exceptions.InvalidCommandException;

public class OpenCommand implements Command {

    @Override
    public boolean execute(CommandContext context) throws InvalidCommandException {

        String[] arguments = context.getArguments();

        if (arguments.length == 0) {
            throw new InvalidCommandException("Usage: open <file>");
        }

        try {

            String text = context.getFileManager().openFile(arguments[0]);

            System.out.println(text);

        } catch (IOException e) {

            throw new InvalidCommandException(e.getMessage());

        }

        return true;
    }
}