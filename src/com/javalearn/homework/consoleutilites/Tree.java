package com.javalearn.homework.consoleutilites;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Tree {

    static ArrayList<String> levels;
    static boolean showSize = false;
    static boolean showHidden = false;
    static boolean showOnlyDirs = false;


    public static void main(String[] args) {

        Path currentRelativePath = Paths.get("");
        String absolutePath = currentRelativePath.toAbsolutePath().toString();

//        absolutePath = "C:\\Users\\User\\Application Data\\";

        File dir = new File(absolutePath);

        for (String arg : args) {

        }
        List<String> list = Arrays.asList(args);
        if (list.indexOf("-h") != -1) {
            showSize = true;
        }

        if (list.indexOf("-a") != -1) {
            showHidden = true;
        }

        if (list.indexOf("-d") != -1) {
            showOnlyDirs = true;
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

        File subFiles[] = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                    return (!file.isHidden()||showHidden)&&(file.isDirectory()||!showOnlyDirs);
            }
        });
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


                idx++;levels.forEach(System.out::print);
                if (showSize) System.out.print("[" + f.length() + "]");

                System.out.println(f.getName());
                if (f.isDirectory()) {
//                    levels.forEach(System.out::print);
                    if (idx - 1 == subFiles.length - 1) {
                        levels.set(level, "   ");
                        levels.add("");
                    }
//                    System.out.println(f.getName());
                    printDirContent(f, level + 1);
                } else {
                    if (!showOnlyDirs) {

//                        System.out.println(f.getName());
                    }
                }
            }
        levels.remove(levels.size() - 1);
    }

}
