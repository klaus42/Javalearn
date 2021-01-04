package com.javalearn.homework.consoleutilites;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Tree {

    static ArrayList<String> levels;

    public static void main(String[] args) {

        Path currentRelativePath = Paths.get("");
        String absolutePath = currentRelativePath.toAbsolutePath().toString();

//        absolutePath = "C:\\Users\\User\\Application Data\\";

        File dir = new File(absolutePath);

        for (String arg : args) {

        }

        levels = new ArrayList<>();
        levels.add("");
        printDirContent(dir, 0);

    }

    public static void printDirContent(File dir, int level) {

        if (dir.canRead() == false) {
            System.out.println("No read permissions");
            return;
        }

        File subFiles[] = dir.listFiles();
        int idx = 0;


        if (level + 1 > levels.size()) {
            levels.add(level - 1, "|  ");
        }
        if (subFiles != null)
            for (File f : subFiles) {

                if (idx < subFiles.length - 1) {
                    levels.set(level, "├--");
                }

                if (idx == subFiles.length - 1) {
                    levels.set(level, "└--");
                }

                levels.forEach(System.out::print);
                idx++;

                if (f.isDirectory()) {
                    if (idx - 1 == subFiles.length - 1) {
                        levels.set(level, "   ");
                        levels.add("");
                    }
                    System.out.println(f.getName());

                    printDirContent(f, level + 1);
                } else {
                    System.out.println(f.getName());
                }
            }
        levels.remove(levels.size() - 1);
    }

}
