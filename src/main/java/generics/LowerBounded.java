package generics;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LowerBounded {
    public static void main(String[] args) {
        /*
        * Lower bound uses Super Keyword
        * ? super MyClass -> unknown type must be MyClass or above
        *
        * */
        // forEach is a default method in java8 Iterable interface

//        List<String> strings = Arrays.asList("One", "Two", "Three", "Four");
        List<String> strings = Stream.of("One", "Two", "Three", "Four").collect(Collectors.toList());
        forEach(System.out::println, strings);
        String s = "";
        strings.forEach((Object o) -> System.out.printf("%s has hashCode %d", o, o.hashCode()));    // Consumer takes Object
        strings.forEach((String o) -> System.out.printf("%s has hashCode %d", o, o.toUpperCase())); // Consumer takes String
    }
    /*forEach method is from Iterable*/
    static <T> void forEach(Consumer<? super T> action, List<T> strings) {
        Objects.requireNonNull(action);
        for (T t : strings) {
            action.accept(t);
        }
    }
}
