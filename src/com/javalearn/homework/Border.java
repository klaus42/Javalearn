package com.javalearn.homework;

import java.util.Scanner;

/*
 * Домашняя работа №2
 * Написать программу, выполняющую рисование рамки вокруг текстовой строки.
 * Программа должна принимать на вход размеры рамки (длина/ширина) и саму строку
 * */


public class Border {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine();

        String phrase = scanner.nextLine();

        if ((height < 3) || width < phrase.length() + 2) {
            System.out.println("Ошибка");
            return;
        }
        String[][] ramka = new String[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ramka[i][j] = " ";
            }

        }

        for (int i = 0; i < width; i++) {
            ramka[0][i] = "*";
        }
        for (int i = 0; i < height; i++) {
            ramka[i][width - 1] = "*";
        }
        for (int i = width - 1; i > 0; i--) {
            ramka[height - 1][i] = "*";
        }
        for (int i = height - 1; i > 0; i--) {
            ramka[i][0] = "*";
        }

        int centerline = Math.round((float) height / 2) - 1;
        int startphrase = width / 2 - Math.round(phrase.length() / (float) 2);

        for (int i = startphrase; i < startphrase + phrase.length(); i++) {
            ramka[centerline][i] = String.valueOf(phrase.charAt(i - startphrase));
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(ramka[i][j]);
            }
            System.out.println("-----");
        }
    }
}
