package java8;

public class LambdaAndSupplierInterface {
    public static void main(String[] args) {


        // Traditional way
        /*
        long begin = System.nanoTime();
        useless();
        long end = System.nanoTime();
        System.out.println("Time taken   "+(end-begin)/1.0e9);

        long begin1 = System.nanoTime();
        useless();
        long end1 = System.nanoTime();
        System.out.println("Time taken   "+(end1-begin1)/1.0e9);
        */

        /*
        CalculateTime.calcuate1(new CalculateTime.Block() {
            @Override
            public void run() {
                useless(1);
            }
        });
        /*/

        // Lambda's
       // CalculateTime.calcuate( () -> useless(1));
       // CalculateTime.calcuate( () -> useless(0));

        /*int result = CalculateTime.calculate(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return op1(1);
            }
        });*/


        int value = CalculateTime.calculate(() -> op1(2));
        System.out.println(value);

    }

    public static void useless(int value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (value == 0) {
            throw new RuntimeException();
        }
    }

    public static int op1(int value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (value == 0) {
            throw new RuntimeException();
        }
        return value * 2;
    }
}
