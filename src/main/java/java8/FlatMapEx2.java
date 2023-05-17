package java8;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Consumer;

// Count no of times the word has appeared for each line
public class FlatMapEx2 {
    public static void main(String[] args) throws IOException {
        String searchString = "localhost";
        String path = "/etc/hosts/";

        //imperitiveSearchWord(searchString, path);

        System.out.println(functionalSearchWord(searchString, path));

    }

    private static void imperitiveSearchWord(String searchString, String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = null;
        long count = 0;
        long lineNumber = 0;
        while ((line = bufferedReader.readLine()) != null) {
            lineNumber++;
            count = 0;
            String[] split = line.split(" ");
            for (int i = 0; i < split.length; i++) {
                if (split[i].contains(searchString)) count++ ;
            }
        }
        System.out.printf("Line %d has found %d ", lineNumber, count);

    }

    private static long functionalSearchWord(String searchString, String path) throws IOException {
        //        Long countUsingJava8 = Files.lines(Paths.get("/etc/hosts"))
        //                .filter(l -> l.contains(searchString)).count();

        //map returns string[] instead of
        // flatmap -
        System.out.println("* * * Using functional style * * *");
        Files.lines(Paths.get(path))
                .map(line -> line.split(" ")).forEach(new Consumer<String[]>() {
                    @Override
                    public void accept(String[] strings) {
                        System.out.println(Arrays.toString(strings));
                    }
                });
        return Files.lines(Paths.get(path)).flatMap( line -> Arrays.stream(line.split(" "))).filter(s -> s.contains(searchString)).count();




    }
}
