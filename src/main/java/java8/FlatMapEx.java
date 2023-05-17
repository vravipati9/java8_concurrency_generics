package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// flatmap flattens the result of a map operation, collection to collection transformation, we use flatmap
//map operation is returning single value, map function is adequate.
//map operation returns Collection itself, use flatMap
public class FlatMapEx {
    public static void main(String[] args) {
        //System.out.println(factorsOfImperitiveStyle(Arrays.asList(1, 2, 6, 8))); //[1, 2, 3, 4, 6, 8]
        System.out.println(factorsOfFunctionalStyle(Arrays.asList(1, 2, 6, 8)));

        System.out.println("* * * testing lower bound generics * * *");
        ArrayList<Integer> integerList = new ArrayList<>();
        numsUpTo(5, integerList);
        System.out.println(integerList);

    }

    private static Set<Integer> factorsOfImperitiveStyle(List<Integer> list) {
        Set<Integer> factors = new HashSet<>();
        for (Integer i : list) {
            factors.addAll(factorsOfImperitiveStyle(i));
        }
        return factors;
    }

    private static List<Integer> factorsOfImperitiveStyle(Integer integer) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= integer; i++) {
            if (integer % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    private static Set<Integer> factorsOfFunctionalStyle(List<Integer> list) {
        Set<Integer> factors = new HashSet<>();
        list.stream().map(i -> factorsOfFunctionalStyle(i)).forEach(integers -> System.out.println(integers)); // [1] [1, 2] [1, 2, 3, 6] [1, 2, 4, 8][]
        list.stream().flatMap((Function<Integer, Stream<?>>) integer -> factorsOfFunctionalStyle(integer).stream()).forEach(integers -> System.out.print(integers)); // 11212361248[]
        //
        return list.stream().flatMap(integer -> factorsOfFunctionalStyle(integer).stream()).collect(Collectors.toSet());
    }

    private static List<Integer> factorsOfFunctionalStyle(Integer number) {
        return IntStream.rangeClosed(1, number).filter(value -> number % value == 0).boxed().collect(Collectors.toList());
    }

    public static void numsUpTo(Integer num, List<? super Integer> output) {
        IntStream.rangeClosed(1, num)
                .forEach(value -> output.add(value));
    }
}
