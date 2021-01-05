package com.javalearn.homework.consoleutilites;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//При запуске на винде нужно использовать параметр
//-Dfile.encoding=cp866


public class Tree {

    static ArrayList<String> levels;
    static boolean showSize = false;
    static boolean showHidden = false;
    static boolean showOnlyDirs = false;


    public static void main(String[] args) {
        List<String> argsList = Arrays.asList(args);
        if (argsList.indexOf("-h") != -1) {
            showSize = true;
        }

        if (argsList.indexOf("-a") != -1) {
            showHidden = true;
        }

        if (argsList.indexOf("-d") != -1) {
            showOnlyDirs = true;
        }

        Stream<String> StartsWithA = argsList.stream().filter(
                (s) -> !s.startsWith("-"));

        String folder = StartsWithA.limit(1).collect(Collectors.joining());
        File dir;
        //folder = "c:\\users\\user";


        dir = new File(folder);

        if (dir.isDirectory() == false) {
            if (folder.length() != 0) {
                System.out.println("\"" + folder + "\" не является директорией");
                System.out.println("Выводим содержимое текущей директории");
            }
            Path currentRelativePath = Paths.get("");
            String absolutePath = currentRelativePath.toAbsolutePath().toString();

//        absolutePath = "C:\\Users\\User\\Application Data\\";

            dir = new File(absolutePath);
        }

        System.out.println(dir.getAbsolutePath());


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
                return (!file.isHidden() || showHidden) && (file.isDirectory() || !showOnlyDirs);
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

                idx++;
                levels.forEach(System.out::print);
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
                }
            }
        levels.remove(levels.size() - 1);
    }

}
