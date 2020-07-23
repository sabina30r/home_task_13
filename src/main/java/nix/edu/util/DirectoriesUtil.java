package nix.edu.util;

import java.io.File;
import java.nio.file.*;

public class DirectoriesUtil {

    public static void copyDirectory(String src, String dest) {

        if (!new File(src).isDirectory()) {
            try {
                throw new NotDirectoryException("\"" + src + "\"isn't a directory!");
            } catch (NotDirectoryException e) {
                System.out.println("Exception from DirectoriesUtil: " + e.getMessage());
            }
        } else {
            try {
                Files.walk(Paths.get(src)).forEach(s -> {
                    try {
                        Path d = Paths.get(dest).resolve(Paths.get(src).relativize(s));
                        if (Files.isDirectory(s)) {
                            if (!Files.exists(d)) {
                                Files.createDirectory(d);
                                System.out.println("Directory \"" + d + "\" was created\n");
                            } else {
                                System.out.println("Directory \"" + d + "\" already exist. Copy data there.\n");
                            }
                            return;
                        }

                        Files.copy(s, d, StandardCopyOption.REPLACE_EXISTING);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("Copying from directory \"" + src + "\" to directory \"" + dest + "\" has been done!");
                });
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
