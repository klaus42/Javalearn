package com.javalearn.homework;

import java.util.Scanner;


/*
* Домашняя работа №1:
* Написать калькулятор, который считывает два числа
* и вычисляет сумму/разность/умножение/деление
* (достаточно выбрать что-то одно) этих чисел и выводит его
* */

public class Calculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.nextLine();
        String op = scanner.nextLine();
        float res;
        switch (op){
            case "+": res = a+b;break;
            case "-": res = a-b;break;
            case "*": res = a*b;break;
            case "/": res = (float)a/b;break;
            case "%": res = a % b;break;
            default: res=10;
        }
        System.out.println("Result: "+res);
    }
}
