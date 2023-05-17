package java8;

import pojos.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class SortUsingLambda {
	public static void main(String...a) {
		List<Person> persons = Arrays.asList(new Person("Veera", "Ravipati", 33),
											new Person("Will", "Smith", 55),
											new Person("Tom", "Hewkins", 30));
		beforeJava8(persons);
		inJava8(persons);
	}
	static void inJava8(List<Person> persons) {
		System.out.println("!!!!!!Using Lambdas!!!!");
		//Collections.sort(persons, (Person o1, Person o2) -> {return o1.getAge() - o2.getAge();});
		Collections.sort(persons, (Person o1, Person o2) -> o1.getAge() - o2.getAge());

		print(persons);
		printConditionally(persons, (Person p) -> p.getFirstName().startsWith("V") );
		printConditionallyUsingPredicate(persons, (p) -> p.getFirstName().startsWith("T"), p -> System.out.println(p.getFirstName()));
		printConditionallyUsingPredicateUsingMethodReference(persons, (p) -> p.getFirstName().startsWith("T"), System.out::println);
	}
	
	static void beforeJava8(List<Person> persons) {
		//Sort list by name
		System.out.println("!!!!!!Using Old Style!!!!!!");
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getAge() - o2.getAge();
			}
		});
		print(persons);
		
	}
	
	static void print(List<Person> persons) {
		for (Person person : persons) {
			System.out.println(person.getAge());
		}
	}
	
	static void printConditionally(List<Person> persons, Conditionally<Person> predicate) {
		System.out.println("!!!!!Using Inline Condition!!!!!");
		for (Person person : persons) {
			if (predicate.test(person)) {
				System.out.println(person.getAge());
			}
		}
	}
	
	static void printConditionallyUsingPredicate(List<Person> persons, Predicate<Person> predicate, Consumer<Person> consume) {
		System.out.println("!!!!!Using Predicate Condition!!!!!");
		for (Person person : persons) {
			if (predicate.test(person)) {
				consume.accept(person);
			}
		}
	}
	
	static void printConditionallyUsingPredicateUsingMethodReference(List<Person> persons, Predicate<Person> predicate, Consumer<Person> consume) {
		System.out.println("!!!!!Using Predicate and Method Reference!!!!!");
		for (Person person : persons) {
			if (predicate.test(person)) {
				consume.accept(person);
			}
		}
	}
	
}

class PersonCompare implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		
		return 0;
	}
}

interface Conditionally<T> {
	boolean test(T t);
}