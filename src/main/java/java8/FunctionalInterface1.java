package java8;

public class FunctionalInterface1 {
    public static void main(String... args) {
        long start = System.nanoTime();
        useless();
        long end = System.nanoTime();
        System.out.println("Time taken(s): "+(end-start)/1.0e9);
    }

    public static void useless() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
    }
}
