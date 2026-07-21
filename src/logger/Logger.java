package logger;

public class Logger {
    public static void Info(String message) {
        System.out.println("[INFO] " + message);
    }
    public static void Error(String message) {
        System.out.println("[ERROR] " + message);
    }
    public static void warn(String message) {
        System.out.println("[WARN] " + message);
    }
    public static void debug(String message) {
        System.out.println("[DEBUG] " + message);
    }
}
