package java8;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class StringJoinStream {

	public static void main(String[] args) {
		//Print the names in Upper case and comma separated
		List<String> names = Arrays.asList("veera", "venkata", "siva");
		System.out.println(
				names.stream()
				.map(String::toUpperCase)
				//joining is from Collectors class
				.collect(joining(", "))
		);
	}

}
