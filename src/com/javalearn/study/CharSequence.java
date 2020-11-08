package com.javalearn.study;

import java.util.*;

public class CharSequence {
    public static void main(String[] args) {
        String seq = "((){}[])";
        Character[] open = {'(', '{', '['};
        Character[] close = {')', '}', ']'};

        List<Character> openChars = Arrays.asList(open);
        List<Character> closeChars = Arrays.asList(close);

        if (seq.length() % 2 != 0) {
            System.out.println("Последовательность ошибочна");
        }

        boolean seqIsOk = true;
        Deque<Character> characterDeque = new ArrayDeque<>();

        for (int i = 0; i < seq.length(); i++) {
            if (openChars.contains(seq.charAt(i))) {
                characterDeque.add(seq.charAt(i));
            } else {
                int idx = closeChars.indexOf(seq.charAt(i));
                Character lastChar = characterDeque.peekLast();
                if (lastChar != null && open[idx] == lastChar) {
                    characterDeque.removeLast();
                } else {
                    seqIsOk = false;
                }
            }
        }

        if (seqIsOk) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
}
