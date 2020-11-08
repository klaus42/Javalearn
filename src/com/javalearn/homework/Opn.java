package com.javalearn.homework;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class Opn {
    public static void main(String[] args) {
        String infix = "3 + 4 * 2 / (1 - 5)^2";

        char[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder opn = new StringBuilder();

        HashMap<Character, Integer> priority = new HashMap<>();
        priority.put('^', 0);
        priority.put('/', 1);
        priority.put('*', 1);
        priority.put('+', 2);
        priority.put('-', 2);
        priority.put('(', 3);
        priority.put(')', 3);


        for (char ch : infix.toCharArray()) {
            if (Character.isDigit(ch)) {
                opn.append(ch);
            }
            if (Character.isAlphabetic(ch) || ch == '(') {
                stack.addLast(ch);
            }
            if (ch == ')') {
                while (stack.peekLast() != null && stack.peekLast() != '(') {
                    opn.append(stack.pollLast());
                }
            }
            if (ch == '*' || ch == '/' || ch == '+' || ch == '-' || ch == '^') {
                if (stack.peekLast() != null) {

                    while ((stack.peekLast() != null && Character.isLetter(stack.peekLast())) ||
                            (priority.containsKey(stack.peekLast()) && priority.get(stack.peekLast()) <= priority.get(ch))) {
                        opn.append(stack.pollLast());
                    }
                }
                stack.addLast(ch);
            }
        }

        while (stack.peekLast() != null) {
            if (stack.peekLast() != '(') {
                opn.append(stack.pollLast());
            } else {
                stack.pollLast();
            }
        }

        System.out.println(opn);

    }
}


