package commands;
import command.CommandContext;

public class CreateCommand implements Command {
   
    
    @Override
    public boolean execute(CommandContext context) {
        // Implementation for create command
        String [] args= context.getArguments();
          if(args.length==0) {
            System.out.println("Usage: create <filename>");
            return true;
        }
        boolean created = context.getFileManager().createFile(args[0]);
        if (created) {
            System.out.println("File created successfully.");
        } else {
            System.out.println("File already exists.");
        }
        return true;
    }
    
}
