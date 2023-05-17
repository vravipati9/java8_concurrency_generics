package java8;

public class Test {
	public static void main(String args[]) {
//runner.run(() -> System.out.println("Hello there!"));

/*		runner.run(() -> {
	System.out.println("Hello there!");
	System.out.println("Hello there 1!");
});
*/

/*	runner.run(() -> {
	System.out.println("Hello there!");
	return 8;
});
*/

// runner.run(() -> 8); //similar to above

//runner.run((int a) -> 8); // passing parameter to interface method which has int datatype

/*
  	Using parameter inside method
  		runner.run((int a) -> {
			System.out.println("Hello there!");
			return 8 + a;
		});
 */

/*
	Using parameter inside method with type inference (can use with comma separator for multiple parameters)
		runner.run((a) -> {
			System.out.println("Hello there!");
			return 8 + a;
		});
*/

/*
 * If we have only one parameter we can use Lambda this way without using brackets
 * 		runner.run(a -> {
			System.out.println("Hello there!");
			return 8 + a;
		});
 */

// In jdk7, If we want to use local variables in anonymous class, we have to declare variable as final.
// But in jdk8, no need to declare variable as final
// But If we reassign variable after initialization and use in anonymous class it throws below exception
// Local variable c defined in an enclosing scope must be final or effectively final

/*
 	In lambda expressions we can use local variables
  		runner.run((a, b) -> {
			System.out.println("Hello there!");
			return c + a + b;
		});
 */


		/*
		 * If we have local variable "d" and declare same variable "d" in lambda expressions it gives compilation error as
		 * Lambda expression's local variable d cannot redeclare another local variable defined in an enclosing
		 * But the same will work in anonymous class and the variable "d" is treated as local variable to anonymous class.
		 */

		/*int c = 10;
		int d = 23;
		Runner runner = new Runner();
		runner.run(new Executable() {

			@Override
			public int execute(int a, int b) {
				System.out.println("Hello there!");
				return c + a + b;
			}
		});

		System.out.println("==================");
		//runner.run(() -> System.out.println("Hello there!"));

		runner.run((a, b) -> {
			System.out.println("Hello there!");
			return c + a + b;
		});

		class Runner {
		public void run(Executable e) {
		System.out.println("Executing code block ...");
		int value  = e.execute(12, 12);
		System.out.println("Return value is " +value);
	}
}

	interface Executable {
		int execute(int a, int b);
	}
*/
	}
}
