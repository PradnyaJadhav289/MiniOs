package history;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
     private final List<String> history;

    public CommandHistory() {
        history = new ArrayList<>();
    }
    public void addCommand(String command) {
        history.add(command);
    }
    public List<String> getHistory() {
        return history;
    }
}
