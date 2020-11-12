package com.javalearn.homework.comparators;

import com.javalearn.study.comparators.MyInteger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class MyNumberComparatorExample {
    public static void main(String[] args) {
//        HashSet<Integer> simpleDividers = new HashSet<>();
//        simpleDividers.add(1);
//
//        int x = 14878571;
//
//        for (int i=2;i<Math.sqrt(x);i++){
//            while (x%i==0){
//                simpleDividers.add(i);
//                x/=i;
//            }
//        }
//
//        if (x!=1){
//            simpleDividers.add(x);
//        }

//        System.out.println(simpleDividers);
        //ArrayList<MyNumber> numarray = new ArrayList<>();

        TreeSet<MyNumber> mynums = new TreeSet<>();
        mynums.add(new MyNumber(1234));
        mynums.add(new MyNumber(11111111));
        mynums.add(new MyNumber(44778855));
        mynums.add(new MyNumber(999));

        for (MyNumber i : mynums) {
            System.out.println(i.getValue());
        }

    }
}
