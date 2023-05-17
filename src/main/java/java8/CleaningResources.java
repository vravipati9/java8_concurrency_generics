package java8;

import java.io.FileWriter;
import java.io.IOException;
//ARM Automatic Resource Management and Execute Around Method pattern
public class CleaningResources {

    public static void main(String[] args) throws IOException {
        MyWriter writer = new MyWriter();
        try {
            writer.write("Hellow");
            writer.write("foo");
            // after calling close only, output will write to file
        } finally {
            writer.close();
        }
    }


}

class MyWriter {
    FileWriter fileWriter;
    public MyWriter() throws IOException {
        fileWriter = new FileWriter("sample.txt");
    }

    public void write(String message) throws IOException {
        if (message.equalsIgnoreCase("foo")) throw new RuntimeException("Invalid message");
        fileWriter.write(message);
    }

    public void close() throws IOException {
        fileWriter.close();
    }
}