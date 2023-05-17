package exceptions;

import java.util.Arrays;

public class ArrayStoreExceptionEx {
    public static void main(String[] args) {
        Integer[] integers = {1, 3, 4, 7};
        Number[] numbers = integers;
        numbers[0] = 1.4;   // ArrayStoreException
        System.out.println(numbers);

        Object x[] = new String[3];
        x[0] = new Integer(0);  // ArrayStoreException
    }
}
