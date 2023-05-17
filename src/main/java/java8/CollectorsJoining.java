package java8;


import java.io.File;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsJoining {
    public static void main(String[] args) {
        //print files with Upper case and Comma separated
        //pwd | pbcopy

        File file = new File("/Users/<<username>>/git/java8_concurrency/example");
        String[] str = file.list();
        String fileNames = new String();
//       for (String fileName : str) {
//            fileNames = fileNames.concat(fileName.toUpperCase()).concat(", ");
//        }
//         System.out.println(fileNames);

//        for (int i = 0; i < str.length; i++) {
//            System.out.print(str[i].toUpperCase());
//            if (i != str.length - 1) {
//                System.out.print(", ");cdc
//            }
//        }

        System.out.println(Stream.of(str).map(String::toUpperCase).collect(Collectors.joining(", ")));
    }
}
