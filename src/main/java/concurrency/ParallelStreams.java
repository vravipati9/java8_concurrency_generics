package concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class ParallelStreams {
  public static void main(String[] args) {
    List<String> names = Arrays.asList(
        "Sara", "Sam", "Joe", "Jack", "Bill", "Bruce", "Bob");

    TimeitStreams.code(() -> printNamesOfLength(names.stream(), 3));  
    System.out.println("<<Using Parallel Stream>>");
    TimeitStreams.code(() -> printNamesOfLength(names.parallelStream(), 3));  
  }
  
  static void printNamesOfLength(Stream<String> names, int length) {
	  names.filter(name -> checkLength(name, 3))
	  //.map(name -> name.toUpperCase())
	  .map(ParallelStreams::convert)
	  .forEach(System.out::println);
  }
  
  private static boolean checkLength(String name, int length) {
	  try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return name.length() == length;
  }
  
  private static Object convert(String name) {
	  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
	  return name.toUpperCase();
  }
  
}