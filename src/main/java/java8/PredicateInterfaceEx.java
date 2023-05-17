package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateInterfaceEx {
    public static void main(String... args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> isEven = integer -> {
            return integer % 2 == 0;
        };
        Predicate<Integer> isGT4 = PredicateInterfaceEx::isGT4;
        System.out.println("filter out odd numbers");
        list.stream().filter(isEven).forEach(System.out::println);

        usePredicate(5, "is Even", isEven);
        usePredicate(10, "is Even", isEven);

        usePredicate(10, "is Even and Greather than 4", isEven.and(isGT4));

    }

    public static void usePredicate(Integer num, String msg, Predicate<Integer> predicate) {
        System.out.println(num + " " + msg + "? " + predicate.test(num));
    }

    public static boolean isGT4(Integer integer) {
        return integer > 4;
    }
}
