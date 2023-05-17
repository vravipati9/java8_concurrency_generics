package java8;

import pojos.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ComparatorInJava8 {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Veera", "Ravipati", 30),
                new Person("Will", "Smith", 55),
                new Person("Tom", "Hewkins", 43));
        Comparator<Person> comparatorByName = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        };
        Comparator<Person> comparatorByAge = (o1, o2) -> new Integer(o1.getAge()).compareTo(o2.getAge());
        System.out.println(sortBy(persons, comparatorByName));



        // another way
        Function<Person, String> byName = person -> person.getFirstName();
        Function<Person, Integer> byAge = Person::getAge;

        //Comparator<Person> comparatorByName1 = (o1, o2) -> byName.apply(o1).compareTo(byName.apply(o2));
        Comparator<Person> comparatorByName1 = comparing(byName);

        System.out.println(sortBy(persons, comparatorByName1));
        System.out.println(sortBy(persons, comparing(Person::getAge))); // comparing() was already provided by Comparator Interface instead of implementing for ourself.


    }
    public static <T extends Comparable<T>> Comparator<Person> comparing(Function<Person, T> by) {
        return (o1, o2) -> by.apply(o1).compareTo(by.apply(o2));
    }

    private static List<Person> sortBy(List<Person> personList, Comparator<Person> person) {
        return personList.stream().sorted(person).collect(Collectors.toList());
    }
}
