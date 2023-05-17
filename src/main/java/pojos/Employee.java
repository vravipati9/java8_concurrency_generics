package pojos;

public class Employee {
	String name;
	Gender gender;
	Integer age;

	public Employee(String name, Gender gender, Integer age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public Integer getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				", gender=" + gender +
				", age='" + age + '\'' +
				'}';
	}
}
