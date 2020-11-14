package com.javalearn.study.comparators;

import java.util.Comparator;

public class MyInteger implements Comparable<MyInteger> {
    private int value;

    public MyInteger() {
    }

    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public int compareTo(MyInteger o) {
        return o.numSum()-this.numSum();
    }

    private int getLastNumber(int value){
        return value%10;
    }

    private int numSum(){
        int counter=0;
        int numsum = 0;
        int nextNum = Math.abs(this.value);
        while (nextNum>0){
            numsum += getLastNumber(nextNum);
            nextNum = nextNum /10;
        }
        return numsum;
    }

}
