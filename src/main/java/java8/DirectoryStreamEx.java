package java8;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class DirectoryStreamEx {
    public static void main(String... args) throws IOException {
        Arrays.stream(new File(".").listFiles()).forEach(file -> file.getName());

        //Without using Directory stream
        String[] fileNames = new File(".").list(new FilenameFilter() {
            @Override
            public boolean accept(File file, String name) {
                return name.endsWith(".java");
            }
        });
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }

        Files.newDirectoryStream(Paths.get("."), new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return entry.toString().endsWith("*.java");
            }
        }).forEach(System.out::println);
    }
}
