package generics;

public class Calculator<T extends Number> {

    private T number;

    public Calculator(T number){
        this.number = number;
    }

    public double square(){
        return number.doubleValue() * number.doubleValue();
    }
}