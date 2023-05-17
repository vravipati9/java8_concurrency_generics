package java8;

import java.util.HashMap;
import java.util.Map;

public class IterateMap {
    private static Map<String, Integer> scores = new HashMap<>();
    public static void main(String[] args) {

        scores.put("Tom", 5);
        scores.put("Jerry", 3);
        scores.put("Spike", 6);
        scores.put("Tyson", 3);
        //iterateUsingImperative(scores);
        iterateUsingFunctionalStyle(scores);
    }

    private static void iterateUsingFunctionalStyle(Map<String,Integer> scores) {
        //scores.keySet().stream().forEach(System.out::print);
        //scores.values().stream().forEach(System.out::print);
        scores.forEach((key, value) -> System.out.println(key +"--"+value));
    }

    private static void iterateUsingImperative(Map<String, Integer> scores) {
        System.out.println(scores.keySet().getClass());
        for (String name: scores.keySet()) {
            System.out.println();
        }
        for (int value : scores.values()) {
        }
    }

}
