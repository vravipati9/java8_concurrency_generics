package java8;

import pojos.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static pojos.Person.getAllPersons;

public class GroupingByAndCount {
    public static void main(String[] args) {
        List<Person> persons = getAllPersons();

        Map<String, Long> personMap =  persons.stream().collect(Collectors.groupingBy(person -> person.getFirstName(), Collectors.counting()));
        System.out.println(personMap);
    }
}
