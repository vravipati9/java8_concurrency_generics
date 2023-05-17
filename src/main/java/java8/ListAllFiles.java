package java8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/*
Using Lambda expression to list files
Using method references
Listing only directories
 */
public class ListAllFiles {
    public static void main(String[] args) throws IOException {
        System.out.println(Paths.get(".").getClass());

        String path = "/Users/<<username>>/git/java8_concurrency";
        File file = new File(path);
        File[] files = file.listFiles();
        Arrays.asList(files).stream().forEach(file1 -> System.out.println(file1));
        System.out.println("* * * Listing only directories * * *");
        Arrays.asList(files).stream().filter(file1 -> file1.isDirectory()).forEach(System.out::println);

        // using nio package
        System.out.println("Using nio package");
        Files.list(Paths.get(".")).forEach(path1 -> System.out.println(path1));
    }


}
