package pojos;

import java.util.Arrays;
import java.util.List;

public class Person {
	private String firstName;
	private String lastName;
	private int age;

	@Override
	public String toString() {
		return "Person{" +
				"firstName='" + firstName + '\'' +
				//", lastName='" + lastName + '\'' +
				", age=" + age +
				'}';
	}

	public Person(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}

	public static List<Person> getAllPersons() {
		return Arrays.asList(
				new Person("Jan", "Ravipati", 42),
				new Person("Bob", "Smith", 63),
				new Person("Sara", "Smith", 33),
				new Person("BillMelinda", "Jason", 33),
				new Person("Jill", "Venkat", 12),
				new Person("Jack", "Ryan", 22),
				new Person("Jack", "Ryan", 75));
	}
}
