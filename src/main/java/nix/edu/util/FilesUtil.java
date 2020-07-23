package nix.edu.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesUtil {

    public static void readLinesWithSubstring(String path, String substring) {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.filter(s -> s.contains(substring))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
