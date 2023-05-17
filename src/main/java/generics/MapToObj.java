package generics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapToObj {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Tom", "Jeff", "Andy");
        System.out.println(names.stream().mapToInt(name -> name.length()).sum());  //Stream to IntStream

        IntStream.range(1, 10).boxed().collect(Collectors.toList()); // IntStream to regular stream, using boxed

        IntStream.range(0, names.size())
                .mapToObj(i -> names.get(0))
                .forEach(System.out::print);
    }
}
