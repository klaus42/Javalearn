package com.javalearn.homework.consoleutilites;


//Реализуйте собственный вариант утилиты grep. Допускается ограничиться работой только с текстовыми файлами.
// Так же, как и стандартная утилита grep, ваша программа должна обрабатывать как стандартный ввод,
// так и файлы, пути к которым указаны в командной строке.
//Программа не должна аварийно завершаться, если какой-либо из файлов,
// перечисленных в аргументах командной строки, не может быть прочитан.

import java.io.*;
import java.util.Scanner;


public class Grep {
    private static final String ANSI_RED = "";
    private static final String ANSI_RESET = "";
//    private static final String ANSI_RED = "\u001B[31m";
//    private static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {

//        String pattern = args[0];
//        String fileName = args[1];

        if (args.length < 2) {
            System.out.println("grep usage:\ngrep [PATTERN] [FILENAME]");
//            return;
        }

        String pattern = "Camera";
        String fileName = "C:\\Users\\klaus\\desktop\\1.txt";
        File file = new File(fileName);

        StringBuilder stringBuilder = new StringBuilder();
        int counter = 1;
//        System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.contains(pattern)) {
                    line = line.replace(pattern, ANSI_RED + pattern + ANSI_RESET);
                    System.out.println(counter + ": " + line);
                }
                counter++;


            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }


}
