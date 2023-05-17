package generics;

import pojos.Person;

import java.util.Comparator;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static pojos.Person.getAllPersons;

public class ToMap {
    public static void main(String[] args) {

        Comparator<Person> sortByName = (person1, person2) -> person1.getFirstName().compareTo(person2.getFirstName());

        Function<Person, String> keyMapper = person -> person.getFirstName(); // given a Person, we need first name as Key
        Function<Person, Person> valueMapper = person -> person; // given a Person, we need Person as Value
        //Map<String, Person> collect = getAllPersons().stream().sorted(sortByName).collect(Collectors.toMap(keyMapper, valueMapper));
        //System.out.println(collect);    //throws java.lang.IllegalStateException: Duplicate key, to avoid this, we could use, groupingBy()

        //Improved version
        Comparator<Person> sortByName1 = Comparator.comparing(Person::getFirstName);
        Function<Person, String> keyMapper1 = Person::getFirstName;
        Function<Person, Person> valueMapper1 = Function.identity(); // because valueMapper is taking and returning same value

        Function<Person, String> classifier = new Function<Person, String>() {
            @Override
            public String apply(Person s) {
                return s.getFirstName();
            }
        };
        BinaryOperator<Person> mergeFunction = new BinaryOperator<Person>() {
            @Override
            public Person apply(Person existingValue, Person newValue) {
                return newValue;
            }
        };
        Map<String, Person> collectAndOverride = getAllPersons().stream().sorted(sortByName).collect(Collectors.toMap(keyMapper, valueMapper, mergeFunction));
        System.out.println(collectAndOverride);




    }
}
