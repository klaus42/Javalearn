package com.javalearn.study.streams;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.generate(() -> {
//            return (int)(Math.random() * Integer.MAX_VALUE - Math.random() *Integer.MAX_VALUE);
            return (int) (Math.random() * 100 - Math.random() * 100);
        });

        stream = stream.filter(a -> a % 2 == 1);
        stream = stream.map(a -> a * 2);
        stream = stream.peek(System.out::println);

        Set<Integer> mySet = stream.limit(15).collect(Collectors.toSet());

        int sum = mySet.stream().reduce((s1, s2) -> s1 + s2).get();

    }
}
