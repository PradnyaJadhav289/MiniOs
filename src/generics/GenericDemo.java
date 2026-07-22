package generics;

public class GenericDemo {

    public static void main(String[] args) {

        Box<String> name = new Box<>();
        name.set("MiniOS");

        Box<Integer> age = new Box<>();
        age.set(21);

        System.out.println(name.get());
        System.out.println(age.get());

        Pair<String,Integer> pair =
                new Pair<>("Age",21);

        System.out.println(pair.getKey());
        System.out.println(pair.getValue());

        Printer.print("Java");
        Printer.print(100);

        Calculator<Integer> c =
                new Calculator<>(5);

        System.out.println(c.square());
    }
}