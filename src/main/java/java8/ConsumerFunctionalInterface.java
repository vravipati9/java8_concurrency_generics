package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerFunctionalInterface {
    public static void main(String... args) {
        Consumer<Integer> consumerInteger = integer -> System.out.println(integer);
        Consumer<Number> consumerNumber = number -> { System.out.println("Printing numbers..."+number.toString()); };
        Consumer<Object> consumerString = string -> { System.out.println("Printing numbers..."+string); };
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<String> listString = Arrays.asList("a", "b", "c");

        list.forEach(consumerNumber);

        listString.forEach(consumerString);

        final List<String> emailTo = new ArrayList<>();
        emailTo.add("abc@gmail.com");
        emailTo.add("def@gmail.com");
        emailTo.add("ghi@gmail.com");
        String[] strings = emailTo.toArray(new String[0]);
        System.out.println(Arrays.asList(strings));
    }


}
