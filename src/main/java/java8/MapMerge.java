package java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapMerge {
    private static Map<String, Integer> scores = new HashMap<>();

    public static void main(String[] args) {
        //Iterate keys and increment the values
        scores.put("Joe", 10);
        scores.put("Jack", 15);
        Arrays.asList("Joe", "Jack", "Siva").stream().forEach(MapMerge::incrementScore);

        System.out.println(scores);

    }

    private static void incrementScore(String name) {
        //compute(key, (keyType, valueType) -> valueType)
        //scores.compute(name,  (s, integer) -> (integer == null) ?  0 : integer +1);

        //merge(key, defaultValueType, (valueTypeForKey, defaultValueType) - > valueType)
        scores.merge(name, 0, (score, value) -> score + value);
    }
}
