package OOPS;

public class Car extends Vehicle{
    private String Color;
    private String Engine;

    public Car(String color, String engine) {
        super(color, engine);
        Color = color;
        Engine = engine;
    }

    public String getMessage(String s){
        return "this is the car class";
    }
}
