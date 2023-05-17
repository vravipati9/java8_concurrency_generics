package java8;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

public class SupplierInterfaceEx {
    static class MyCls {
        MyCls() {
            System.out.println("creating...");
        }
    }

    static class APICall {
        public String result() {
            return "No matching results";
        }
    }

    public static void main(String[] args) {
        Supplier<Integer> factory = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 2;
            }
        };
        System.out.println(factory.get());

        Supplier<Date> date = () -> new Date();
        System.out.println(date.get());

        //Lazy Initialization
        System.out.println("Lazy initialization will not work. creating object regardless of condition in use()");
        use(new MyCls(), 7);
        use(new MyCls(), 3);

        System.out.println("Lazy works by using Supplier. Created one object for MyCls" );
        use(() -> new MyCls(), 7);
        use(() -> new MyCls(), 3);

        System.out.println("** Use of Supplier in Optional **");
        List<String> names = Arrays.asList("Jack", "Jill");

        System.out.println(names.stream().filter(s -> s.length() == 5).findFirst().orElseGet(() -> new APICall().result()));

    }

    private static void use(Supplier<Integer> factory) {
        System.out.println(factory.get());
    }
    private static void use(MyCls cls, Integer i) {
        if (i < 5) {
            System.out.println(cls);
        }
    }
    private static void use(Supplier<MyCls> cls, Integer i) {
        if (i < 5) {
            System.out.println(cls.get());
        }
    }
}
