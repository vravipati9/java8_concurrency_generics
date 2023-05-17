package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class HigherOrderUsingLambda {
    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1, 3, 4, 5, 7, 8, 9);
        List<Integer> numbers2 = Arrays.asList(2, 3, 4, 6, 8, 9);

        Predicate<Integer> isGT3 = (integer -> integer > 3);
        Predicate<Integer> isGT4 = (integer -> integer > 4);

        numbers1.stream().filter(isGT3);


    }



}
