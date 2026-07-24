package generics;

public class Printer {

    public static <T> void print(T value){
        System.out.println(value);
    }
}