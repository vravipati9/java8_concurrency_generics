package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SubstitutionPrinciple {
    public static void main(String... args) {

        List<Object> objs = Arrays.asList(2, 3.14, "four");
        List<Number> nums = new ArrayList<>();
        List<Integer> ints = Arrays.asList(1,2,3);
        List<? extends Number> nums1 = ints;

        List<Double> dbls = Arrays.asList(8.78, 9.14);

        Collections.copy(objs, ints);

        Collections.<Number>copy(objs, ints);
        System.out.println("dbls = " + objs);
        System.out.println(sum(ints));

        System.out.println("* * * copying * * *");
        List<Object> listOfObjects = new ArrayList<>(9);
        addAll(listOfObjects, new Integer[] {1, 3, 4});
    }

    public static <T> void copy(List<T> dst, List<? extends T> src) {
        System.out.println("dst = [" + dst + "], src = [" + src + "]");
    }

    /**
     * method that takes a collection of numbers, converts each to a double,
     * and sums them up:
     */
    private static double sum(Collection<? extends  Number> numbers) {
        double d = 0.0;
        double sum = numbers.stream().mapToDouble(value -> ((Number) value).doubleValue()).sum();
        return sum;
    }

    /**
     * method that takes a collection of numbers and an integer n, and
     * puts the first n integers, starting from zero, into the collection:
     */
    private static void count(Collection<? super Number> elements, int n) {
        elements.add(1);
        elements.add(1.1);
       // elements.add("");
    }

    private static <T> void addAll(List<? super T> dest, T[] elements) {
        System.out.println(dest.size());    //IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
        for (int i = 0; i < elements.length; i++) {
            System.out.println(dest.get(i));
        }
//        System.out.println();
        for (Object o: dest) {
            System.out.println(dest);
        }
    }
}
