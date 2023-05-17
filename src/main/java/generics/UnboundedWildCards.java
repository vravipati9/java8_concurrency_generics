package generics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnboundedWildCards {
    public static void main(String[] args) {

        List<?> listOfUnKnown = Arrays.asList(1, "One", 1.1, new BigDecimal(12));
        processUnboundedValues(listOfUnKnown);
    }

     static <T> void processUnboundedValues(List<?> unKnownTypes) {
         unKnownTypes.forEach(o -> System.out.println(o));
    }
}
