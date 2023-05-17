package java8;

//1) Subtypes automatically carry over the default methods from their supertypes
//2) For interfaces that contribute a default method, the implementation in a subtype takes precedence over the one in supertypes
//3) Implementation in classes(Class hierarchy takes precedence over Interface hierarchy), including abstract declarations, take precedence over all interface defaults.
//4) If there is a conflict between two or more default method implementations, or there's a default-abstract conflict between
//   two interfaces, the inheriting class should disambiguate

public class DefaultMethodsRules {
    public static void main(String... args) {
        SeaPlane seaPlane = new SeaPlane();
        seaPlane.turn();    // rule number 1
        seaPlane.takeOff(); // rule number 2
        seaPlane.land();    // rule number 3
        seaPlane.setAltitude(1000);
        seaPlane.cruise();  // rule number 4
    }
}

interface Fly {
    default void takeOff() {
        System.out.println("Fly::takeOff");
    }
    default void turn() {
        System.out.println("Fly::turn");
    }
    default void land() {
        System.out.println("Fly::land");
    }
    default void cruise() {
        System.out.println("Fly::cruise");
    }
}
interface FastFly extends Fly {
    public default void takeOff() {
        System.out.println("FastFly::takeOff");
    }
}

interface Sail {
    default void cruise() {
        System.out.println("Sail::cruise");
    }
}
class SeaPlane extends Vehicle implements FastFly, Sail {
    // with out this method, cruise method failed in line no 16, when method ambiguity comes
    public void cruise() {
        System.out.println("SeaPlane::cruise");
        if (altitude < 10) {
            Sail.super.cruise();
        } else {
            FastFly.super.cruise();
        }
    }
    private int altitude;
    public void setAltitude(int newAltitude) {
        altitude = newAltitude;
    }
}

class Vehicle {
    public void land() {
        System.out.println("Vehicle:land");
    }
}
