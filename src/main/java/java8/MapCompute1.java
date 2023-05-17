package java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapCompute1 {
    private static Map<String, Integer> scores = new HashMap<>();

    public static void main(String[] args) {
        //Iterate keys and increment the values
        scores.put("Joe", 10);
        scores.put("Jack", 15);
        Arrays.asList("Joe", "Jack", "Siva").stream().forEach(MapCompute1::incrementScore1);

        System.out.println(scores);

    }

    private static void incrementScore(String name) {
        scores.computeIfPresent(name,  (s, integer) -> integer +1); //with just compute, it throws NullPointerException for siva
    }


    private static void incrementScore1(String name) {
        scores.computeIfAbsent(name,  (integer) ->  0);
        scores.computeIfPresent(name,  (s, integer) -> integer +1); //with just compute, it throws NullPointerException for siva

    }
}
