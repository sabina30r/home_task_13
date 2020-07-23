package nix.edu;

import nix.edu.util.DirectoriesUtil;
import nix.edu.util.FilesUtil;


public class Main {
    private final static String path = "file.txt";
    private final static String substring = "@";
    private final static String directoryFrom = "directory_from";
    private final static String directoryTo = "directory_to";

    public static void main(String[] args) {
        System.out.println("Task 1. Reading lines that contain current substring: \n");
        FilesUtil.readLinesWithSubstring(path, substring);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Task 2. Copying directory's content: \n");
        DirectoriesUtil.copyDirectory(directoryFrom, directoryTo);
    }
}
