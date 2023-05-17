package generics;

//method that counts the number of elements in an array T[] that are greater than a specified element elem.
public class BoundedTypeParameters {
    public static void main(String[] args) {
        System.out.println(countGreaterThan(new String[] {"Animal", "Buffalo", "Cat", "Dog", "Elephant", "Frog", "Goat"}, "Cat"));
    }

/*    private static <T> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T t : anArray) {
            if (t > elem) {
                count++;   // gives compilation error, (>) o primitive types such as short, int, double, long, float, byte, and char
            }
        }
        return count;
    }*/

    private static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T t : anArray) {
            if (t.compareTo(elem) > 0) {  // T (String) extends Comparable
                count++;
            }
        }
        return count;
    }
}
