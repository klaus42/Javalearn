package com.javalearn.study.iterators;

public class LineTest {
    public static void main(String[] args) {
        Line line = new Line("abaab     abnsbn    nbngd b  sdkjhkjfds   ababa");
        for (String word : line) {
            System.out.println(word);
        }
    }
}
