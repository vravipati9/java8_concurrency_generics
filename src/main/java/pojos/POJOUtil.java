package pojos;

import java.util.Arrays;
import java.util.List;

public class POJOUtil {
    public static List<Employee> createEmployee() {
        return Arrays.asList(
                new Employee("Sara", Gender.FEMALE, 20),
                new Employee("Sara", Gender.FEMALE, 22),
                new Employee("Tom", Gender.FEMALE, 31),
                new Employee("Bob", Gender.MALE, 36),
                new Employee("Jack", Gender.MALE, 33),
                new Employee("Jack", Gender.MALE, 34)
        );
    }
}
