package java8;

public class EffectivelyFinal {
    public static void main(String[] args) {
        int max = 100;
        Thread t = new Thread(() -> System.out.println("In Thread>>"+max));
        t.start();
        //max = 11; Compile time error, local variable referenced from a lambda expression must be final or effectively final
        System.out.println("In Main>>"+max);
    }
}
