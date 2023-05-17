package java8;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Count no of occurrences in a file for a given string
public class StreamFilter {
    public static void main(String[] args) throws IOException {
        String searchString = "host";
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("/etc/hosts"));
//        String line = null;
//        long count = 0;
//        while ((line = bufferedReader.readLine()) != null) {
//            if (line.contains(searchString)) {
//                count++;
//            }
//        }
//        System.out.printf("%s found in %d places \n", searchString, count);

        Long countUsingJava8 = Files.lines(Paths.get("/etc/hosts"))
                .filter(l -> l.contains(searchString)).count();

        System.out.printf("%s found in %d places ", searchString, countUsingJava8);

    }
}
