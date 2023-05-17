package java8;

import pojos.Person;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static pojos.Person.getAllPersons;
/*
Group By first character and find older person in that group
 */
public class ReducingMethodEx1 {
    public static void main(String... args) {
        Map<Character, List<Person>> groupedByFirstCharacter = getAllPersons().stream().
                collect(Collectors.groupingBy(o -> o.getFirstName().charAt(0)));
        System.out.println(groupedByFirstCharacter);

        BinaryOperator<Person> eldest = new BinaryOperator<Person>() {
            @Override
            public Person apply(Person person1, Person person2) {
                return person1.getAge() > person2.getAge() ? person1 : person2;
            }
        };
        groupedByFirstCharacter.keySet()
                .stream()
                .map(character -> groupedByFirstCharacter.get(character).stream().reduce(eldest))

                .forEach(System.out::println);
    }
}
