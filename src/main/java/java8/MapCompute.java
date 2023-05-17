package java8;

import java.util.HashMap;
import java.util.Map;

public class MapCompute {
    public static void main(String[] args) {
        //Iterate keys and increment the values
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Joe", 10);
        scores.put("Jack", 15);
        incrementScore(scores, "Joe");
        System.out.println(scores);

    }

    private static void incrementScore(Map<String,Integer> scores, String name) {
        scores.compute(name,  (s, integer) -> integer + 1);
    }
}
