package generics;

import pojos.Employee;
import pojos.POJOUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.toList;
import static java8.ComparatorInJava8.comparing;

public class SortEmployee {
    private static List<String> sampleStrings = Arrays.asList("this", "is", "a", "list", "of", "strings");
    public static void main(String[] args) {
        List<Employee> employee = POJOUtil.createEmployee();

        // Default sort from Java 7
        Collections.sort(sampleStrings);
        System.out.println(sampleStrings);

        // java8
        System.out.println(sampleStrings.stream().sorted().collect(toList()));

        sampleStrings.sort((o1, o2) -> o1.length() - o2.length());
        System.out.println(sampleStrings);

        // Improved
        sampleStrings.sort(comparingInt(String::length));

        // Sort by length then alpha using sorted
        /*public List<String> lengthSortThenAlphaSortUsingSorted() {
            return sampleStrings.stream()
                    .sorted(comparingInt(String::length)
                            .thenComparing(naturalOrder()))
                    .collect(toList());
        }

        // Sort by length then reverse alpha using sorted
        public List<String> lengthSortThenReverseAlphaUsingSorted() {
            return sampleStrings.stream()
                    .sorted(comparing(String::length)
                            .thenComparing(reverseOrder()))
                    .collect(toList());
        }
*/



    }
}
