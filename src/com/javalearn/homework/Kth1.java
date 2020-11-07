package com.javalearn.homework;

import java.util.Scanner;

/*
 * Составьте программу, вычисляющую k-ый символ строки (0 < к < 2^63).
 * В программе разрешается использовать только примитивные целочисленные типы данных,
 * то есть, в частности, массивы и строки использовать нельзя.
 * Для любого к из указанного диапазона программа должна работать не дольше 2 секунд.
 * Точкой входа в программу должен быть метод main публичного класса Kth.
 *
 * */

public class Kth1 {

    public static int lastCountOfdigits = 1;
    public static long prevNumber = 1;
    public static int lastPower = 1;
    public static long lastTenPower = 1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long k = in.nextLong();
        long number;
        long length = 1;
        long nextlength;
        long start = System.currentTimeMillis();
        nextlength = getDigitCountInPower(lastTenPower);

        while (nextlength < k + 1) {
            length = nextlength;
            lastPower++;
            nextlength = length + getDigitCountInPower(lastPower);
        }
        System.out.println("next " + nextlength);
        System.out.println("current " + length);

        lastPower--;
        number = tenPower(lastPower) - 1;

        lastTenPower = tenPower(lastPower - 1);
        lastCountOfdigits = lastPower;
        if (length > 0) {
            nextlength = length;
        } else {
            nextlength = getDigitCountInPower(lastPower);
        }

        long requiredDistance = k - nextlength;
        lastCountOfdigits++;
        lastTenPower *= 10;
        long numberOfDigitsToJump = requiredDistance / lastCountOfdigits;

        nextlength = nextlength + numberOfDigitsToJump * lastCountOfdigits;
        number = number + numberOfDigitsToJump;

        while (nextlength < k + 1) {
            length = nextlength;
            number++;
            nextlength += getCountsOfDigits(number);
        }
        long dist = k - length;
        System.out.println("Symbol: " + getSymbol(number, dist));


        long end = System.currentTimeMillis();
        System.out.println((float) (end - start) / 1000);

        System.out.println(tenPower(5));

    }


    public static int getCountsOfDigits(long number) {

        if (number / lastTenPower < 10) {
            return lastCountOfdigits;
        } else {
            lastPower++;
            lastTenPower = lastTenPower * 10;
            lastCountOfdigits++;
            return lastCountOfdigits;
        }
        //return (number < 10 ? 1 : 1 + getCountsOfDigits(number / 10));
    }

    public static long getSymbol(long number, long k) {
        int cnt = 0;
        long dist = getCountsOfDigits(number) - k;
        while (cnt < dist - 1) {
            number = number / 10;
            cnt++;
        }
        return number % 10;
    }

    public static long tenPower(long power) {
        return (power < 1 ? 1 : 10 * tenPower(power - 1));
    }


    public static long getDigitCountInPower(long power) {
        return 9 * tenPower(power - 1) * power;
    }

}
