package commands;
import command.CommandContext;
import exceptions.InvalidCommandException;

public interface Command {
boolean execute(CommandContext commandContext) throws InvalidCommandException;
}
