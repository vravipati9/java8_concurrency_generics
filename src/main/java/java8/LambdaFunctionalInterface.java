package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaFunctionalInterface {
    public static void main(String[] args) {


        List<Integer> values = Arrays.asList(1, 2, 3);
        values.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                CalculateTime.calcuate(() -> op1(integer));
            }
        });
        System.out.println("------------");
        values.stream().map(integer -> integer * 1.0).forEach(System.out::println);
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
