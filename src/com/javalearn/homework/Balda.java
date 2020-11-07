package com.javalearn.homework;

import java.lang.reflect.Array;
import java.util.*;

public class Balda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bigWord = scanner.nextLine();

        boolean order = true; //для двух человек - true - первый, false - второй

        HashSet<Character> charSet = new HashSet<>();

        Set<String> words = new HashSet<>();

        for (char ch : bigWord.toCharArray()) {
            charSet.add(ch);
        }

        int score = 0;
        int scoreTwo = 0;
        int eq = 0;
        int emptywords = 0;
        System.out.println("Игрок №1, введите слово, чтобы продолжить играть или нажмите enter для выхода");
        String littleWord = scanner.nextLine();
        HashSet<Character> littleSet = new HashSet<>();

        while (emptywords < 2) {
            if (littleWord.length() == 0) {
                emptywords++;
            }

            if (words.contains(littleWord)) {
                System.out.println("Слово \"" + littleWord + "\" уже использовали");
            } else {

                if (littleWord.length() > 0) {
                    for (char ch : littleWord.toCharArray()) {
                        if (charSet.contains(ch)) {
                            eq++;
                        }
                    }
                    if (eq == littleWord.length()) {
                        if (order) {
                            score += littleWord.length();
                        } else {
                            scoreTwo += littleWord.length();
                        }
                        //System.out.println("Current Score: " + score);
                        words.add(littleWord);
                        eq = 0;
                    } else {
                        System.out.println("Нет такого слова в исходном");
                        eq = 0;
                    }
                }
            }
            if (emptywords == 2) {
                break;
            }

            order = !order;
            System.out.println("Игрок № " + (order ? "1" : "2") + ", введите слово, чтобы продолжить играть или нажмите enter для выхода");
            littleWord = scanner.nextLine();
        }
        System.out.println("Summary Score one: " + score);
        System.out.println("Summary Score two: " + scoreTwo);
    }
}
