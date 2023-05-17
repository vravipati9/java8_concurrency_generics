package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionFunctionalInterface {

    public static void main(String... args) {
        Function<Integer, Double> doubleIt = (Integer value) -> value * 2.0;
        Function<String, Integer> countLength = (String string) -> {
            System.out.println("counting lenght and doubling it");
            return string.length();
        };
        Function<String, String> appendString = s -> {
            System.out.println("appending string");
            return s.concat("ravipati");
        };

        //System.out.println(doubleIt.apply(2));

        List<String> names = Arrays.asList("Veera"); //, "Venkata", "Siva"

        names.stream().map(countLength.andThen(doubleIt)).forEach(o -> System.out.println(o.toString()));


        System.out.println("-------using apply and andThen---------");
        names.stream().map(appendString.andThen(countLength)).forEach(System.out::println);

        System.out.println("-------using compose-------------------");
        names.stream().map(countLength.compose(appendString)).forEach(System.out::println);


    }
}
