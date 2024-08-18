package OOPS;

public class Vehicle {
    private String Color;
    private String Engine;

    public Vehicle(String color, String engine) {
        Color = color;
        Engine = engine;
    }

    public String getMessage(){
        return "this is the vehicle class";
    }
    public int getNum(){
        return 2;
    }

    public String getMessage(String s){
        return "this is the vehicle ";
    }
}
