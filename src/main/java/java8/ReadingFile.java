package java8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFile {
    public static void main(String[] args) throws IOException {
        String fileName = "/etc/hosts";
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
        fileReader.close();

        // Using Streams
        System.out.println("*** Using Streams ***");
        new BufferedReader(new FileReader(fileName)).lines().forEach(ln -> System.out.println(ln));



    }
}
