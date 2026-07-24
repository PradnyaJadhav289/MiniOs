package generics;

/**
 * Small demo application that shows basic usage of the project's generic
 * utility classes: {@link Box}, {@link Pair}, {@link Printer} and
 * {@link Calculator}.
 *
 * This class is intentionally simple — its purpose is purely educational,
 * to exercise generic types and helper methods from the {@code generics}
 * package.
 */
public class GenericDemo {

    /**
     * Application entry point. Demonstrates:
     * - a generic container (`Box<T>`),
     * - a key/value pair (`Pair<K,V>`),
     * - a generic printer utility (`Printer`), and
     * - a simple generic calculator (`Calculator<T>`).
     */
    public static void main(String[] args) {

        // Example 1: Generic container holding a String
        Box<String> name = new Box<>();
        name.set("MiniOS");

        // Example 2: Generic container holding an Integer
        Box<Integer> age = new Box<>();
        age.set(21);

        // Print values stored in the boxes
        System.out.println(name.get());
        System.out.println(age.get());

        // Example 3: Pair demonstrating two generic type parameters
        Pair<String,Integer> pair = new Pair<>("Age", 21);

        // Print the pair's key and value
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());

        // Example 4: Utility that accepts any type and prints it
        Printer.print("Java");
        Printer.print(100);

        // Example 5: Generic calculator instantiated with Integer
        Calculator<Integer> c = new Calculator<>(5);

        // Print computed square value
        System.out.println(c.square());
    }
}