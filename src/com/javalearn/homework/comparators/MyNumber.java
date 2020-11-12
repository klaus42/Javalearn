package com.javalearn.homework.comparators;

import java.util.HashSet;

public class MyNumber implements Comparable<MyNumber> {

    private int value;

    public MyNumber() {
    }

    public MyNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(MyNumber num) {
        return getSimpleDividersCount(num.value) - getSimpleDividersCount(this.value);
    }

    private int getSimpleDividersCount(int x) {
        HashSet<Integer> simpleDividers = new HashSet<>();
        simpleDividers.add(1);
        for (int i = 2; i < Math.sqrt(x); i++) {
            while (x % i == 0) {
                simpleDividers.add(i);
                x /= i;
            }
        }

        if (x != 1) {
            simpleDividers.add(x);
        }
        return simpleDividers.size();
    }

}
