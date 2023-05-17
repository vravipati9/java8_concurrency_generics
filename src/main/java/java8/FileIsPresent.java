package java8;

import java.io.File;

public class FileIsPresent {
    public static void main(String... args) {
        String directory = "\\\\test\\test\\";
        System.out.println(directory);
        String fileName = directory.concat("abc.doc");
        File f = new File(fileName);
        if (f.exists() && !f.isDirectory()) {
            System.out.println("file exist");
            System.out.println(f.getName());
        }
    }
}
