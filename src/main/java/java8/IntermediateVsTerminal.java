package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateVsTerminal {
    // Intermediate operations are lazy and Terminal operations are eager.

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(
                numbers.stream()
                        .filter(IntermediateVsTerminal::isEven)
                        .map(IntermediateVsTerminal::doubleIt)
                        .filter(IntermediateVsTerminal::isGT4)
                        .count() // if we remove count(), computation is lazy, count() is eager
        );
        // Better to stay with Streams instead of using terminal operation like above, because streams provide laziness,
        Stream<Integer> result = numbers.stream()
                .filter(IntermediateVsTerminal::isEven)
                .map(IntermediateVsTerminal::doubleIt)
                .filter(IntermediateVsTerminal::isGT4);
        System.out.println("Find first element from result.."+result.findFirst()); // findFirst returns Optional[8], once it get the first element, it will not process further, means 5 will not evaluate.

    }
    public static boolean isEven(int number) {
        System.out.println("Is Even called  "+number);
        return number % 2 == 0;
    }
    public static int doubleIt(int number) {
        System.out.println("Is double called "+number);
        return number * 2;
    }
    public static boolean isGT4(int number) {
        System.out.println("is GT4 called "+number);
        return number > 4;
    }

}
