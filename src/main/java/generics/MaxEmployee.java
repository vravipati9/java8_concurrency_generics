package generics;

import pojos.Employee;
import pojos.POJOUtil;

import java.util.Comparator;
import java.util.List;

public class MaxEmployee {
    public static void main(String[] args) {
        List<Employee> employee = POJOUtil.createEmployee();
        Employee employee1 = employee.stream().max(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        }).get();

        Employee employee2 = employee.stream().max((Object o1, Object o2) -> o1.toString().compareTo(o2.toString())).get();
        System.out.println(employee1);
        System.out.println(employee2);


    }
}
