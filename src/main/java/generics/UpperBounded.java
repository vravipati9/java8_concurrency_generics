package generics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpperBounded {
    public static void main(String[] args) {
        //
        /*
        * Upper bounded wild card uses extends keyword
        * ? extends Number
        * can use any Number methods
        * */
        List<? extends Number> listOfNumbers = Arrays.asList(new Integer(12), new BigDecimal(23), new Double(1.0));
/*      This will not work, because in Upperbounded wildcards, we can only read not write
        List<? extends Number> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(2);
        listOfIntegers.add(2);*/
        sumList(listOfNumbers);
    }

    static void sumList(List<? extends Number> listOfNumbers) {
        System.out.println(listOfNumbers.stream().mapToDouble(value -> value.doubleValue()).sum());
    }
}
