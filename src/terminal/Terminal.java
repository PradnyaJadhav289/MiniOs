package MiniOS.src.terminal;

public class Terminal{
 public static void showhelp() {
                    System.out.println("Available commands:");
                    System.out.println("  help - Show this help message");
                    System.out.println("  exit - Exit JavaOS");
    }
    public static void showwelcome() {
        System.out.println("========================================");
        System.out.println("         Welcome to JavaOS v1.0");
        System.out.println("========================================");
        System.out.println("Type 'help' to see available commands.\n");
    }

    public static void showexit() {
        System.out.println("Shutting down JavaOS...");
    }
    public static void showdate() {
        System.out.println("Current date and time: " + java.time.LocalDateTime.now());
    }
    public static void showtime() {
        System.out.println("Current time: " + java.time.LocalTime.now());
    }
    public static void clearScreen() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }
    public static void unknownCommand() {
        System.out.println("Unknown command. Type 'help' to see available commands.");
    }
    public static void showabout() {
        String javaVersion = System.getProperty("java.version");
        System.out.println("Java version: " + javaVersion);
        System.out.println("OS: " + System.getProperty("os.name"));
        System.out.println("User: " + System.getProperty("user.name"));


        System.out.println("A simple operating system written in Java.");
    }
}
