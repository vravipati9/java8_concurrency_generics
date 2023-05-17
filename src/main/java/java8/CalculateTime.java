package java8;

import java.util.function.Supplier;

public class CalculateTime {
    @FunctionalInterface
    interface Block {
        public void run();
    }

    /*public static void calcuate(Block block) {
        long begin = System.nanoTime();
        block.run();
        long end = System.nanoTime();
        System.out.println("Time taken   "+(end-begin)/1.0e9);
    }*/
    public static void calcuate1(Block block) {
        long begin = System.nanoTime();
        block.run();
        long end = System.nanoTime();
        System.out.println("Time taken   "+(end-begin)/1.0e9);
    }

    public static void calcuate (Runnable block) {
        long begin = System.nanoTime();
        try {
            block.run();
        } finally {
            long end = System.nanoTime();
            System.out.println("Time taken   "+(end-begin)/1.0e9);
        }
    }

    public static <T> T calculate(Supplier<T> codeBlock) {
        long begin = System.nanoTime();
        try {
            return codeBlock.get();
        } finally {
            long end = System.nanoTime();
            System.out.println("Time taken   "+(end-begin)/1.0e9);
        }
    }

}
