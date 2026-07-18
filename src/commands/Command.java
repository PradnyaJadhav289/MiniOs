package commands;
import command.CommandContext;

public interface Command {
boolean execute(CommandContext context);
}
