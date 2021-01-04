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

//            Stream.generate(() -> "│  ").limit(level).forEach(System.out::print);
//

//                if (idx == 0 && subFiles.length == 1) {
//                    System.out.print("└");
//                }

                if (idx < subFiles.length - 1) {
//                System.out.print("├");
                    levels.set(level, "├--");
                }

                if (idx == subFiles.length - 1) {
                    levels.set(level, "└--");
//                System.out.print("└");
                    //levels.set(level,"   ");
                }
                levels.forEach(System.out::print);


//            levels.set(level,"");
                idx++;

                if (f.isDirectory()) {
                    if (idx - 1 == subFiles.length - 1) {
                        levels.set(level, "   ");
//                    levels.remove(0);
//                    levels.remove(0);

                        levels.add("");
//                System.out.print("└");
                        //levels.set(level,"   ");
                    }
//                Stream.generate(() -> "│  ").limit(level).forEach(System.out::print);
//                if (level > 0 && subFiles.length > 1) {
//                    System.out.print("├");
//                }
//                if (level > 0 && subFiles.length == 1) {
//                    System.out.print("└");
//                }
//                if (level > 0 && subFiles.length == 0) {
//                    System.out.print("└");
//                }
//                if (level == 0 && subFiles.length > 1) {
//                    System.out.print("├");
//                }
//
//                if (level == 0 && subFiles.length == 1) {
//                    System.out.print("└");
//                }
                    System.out.println(f.getName());
//                idx++;
                    printDirContent(f, level + 1);
                } else {
                    if (idx - 1 == subFiles.length - 1) {
                        // levels.remove(levels.size()-1);
//                System.out.print("└");
                        //levels.set(level,"   ");
                    }
//                Stream.generate(() -> "│  ").limit(level).forEach(System.out::print);
//
////                if (idx == 0 && subFiles.length == 1) {
////                    System.out.print("└");
////                }
//
//                if (idx < subFiles.length - 1) {
//                    System.out.print("├");
//                }
//
//                if (idx == subFiles.length - 1) {
//                    System.out.print("└");
//                }
//                idx++;
                    System.out.println(f.getName());
                }
            }
        levels.remove(levels.size() - 1);
    }

}
