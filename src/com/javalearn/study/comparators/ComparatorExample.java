package com.javalearn.study.comparators;

import java.util.*;

public class ComparatorExample {
    public static void main(String[] args) {
        ArrayList<MyInteger> numarray = new ArrayList<MyInteger>();

        TreeSet<MyInteger> mynums = new TreeSet<MyInteger>();
        mynums.add(new MyInteger(1234));
        mynums.add(new MyInteger(11111111));
        mynums.add(new MyInteger(44778855));
        mynums.add(new MyInteger(999));

        for (MyInteger i : mynums) {
            System.out.println(i.getValue());
        }

    }
}
