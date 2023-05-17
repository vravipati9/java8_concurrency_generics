package java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByAndCountEx {
    public static void main(String[] args) throws IOException {
//        Files.lines(Paths.get("/Users/sivaravipati/git/java8_concurrency/example/sample"))
//                .map(line -> line.split(" "))
//                .map(strings -> Arrays.asList(strings)).forEach(System.out::print);

        long wordsCount = Files.lines(Paths.get("/Users/sivaravipati/git/java8_concurrency/example/sample"))    //read lines
                .flatMap(line -> Arrays.stream(line.split(" ")))    // map returns list of strings for a given line, so used flatMap to convert to stream
                .filter(word -> word.equals("RAJU"))
                .mapToLong(word -> 1)
                .sum();
                //.count();       // count word "Raju" in all lines
        System.out.printf("%d occurrences found for a given word: %s ", wordsCount, "RAJU");


        Map<String, Long> collect = Files.lines(Paths.get("/Users/sivaravipati/git/java8_concurrency/example/sample"))    //read lines
                .parallel()
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println("\n");
        System.out.println("Words count size "+collect.size());
        System.out.println("Words count size "+collect.get("RAJU"));

    }
}
