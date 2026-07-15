package commands;
import java.util.HashMap;
import java.util.Map;
public class CommandRegistry {
     public static Map<String , Command>registerCommands() {
        Map<String , Command> commandMap = new HashMap<>();
        commandMap.put("help", new HelpCommand());
        commandMap.put("about", new AboutCommand());
        commandMap.put("date", new DateCommand());
        commandMap.put("time", new TimeCommand());
        commandMap.put("clear", new ClearCommand());
        commandMap.put("exit", new ExitCommand());
        return commandMap;
     }
}
