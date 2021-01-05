package com.javalearn.homework.consoleutilites;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Wc {
    public static void main(String[] args) {
        for (String arg : args) {
            if (arg.charAt(0) != '-') { //если первый символ параметра не тире, то это путь к файлу
                File file = new File(arg);
                int linesCounter = 0;
                int wordCounter = 0;
                int charCounter = 0;
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        charCounter += line.length();
                        List<String> words = Arrays.asList(line.split("\\s+"));
                        wordCounter += words.size();
                        linesCounter++;
                    }
                    System.out.println("\t" + linesCounter + "\t" + wordCounter + "\t" + charCounter + "\t" + file.getName());
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
    }
}
