package com.javalearn.homework;

import java.util.ArrayList;

public class UniqArray {
    public static void main(String args[]){

        int[] ls= {1, 1, 1, 1, 2, 2, 3, 4, 5};
        ArrayList<Integer> uniqArray = new ArrayList<Integer>();

        for (int n:ls){
            if (uniqArray.indexOf(n)==-1){
                uniqArray.add(n);
            }
        }

        System.out.println(uniqArray);
    }
}
