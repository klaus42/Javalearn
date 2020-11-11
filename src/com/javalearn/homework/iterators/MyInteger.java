package com.javalearn.homework.iterators;

import java.util.Iterator;

public class MyInteger implements Iterable<Integer> {

    private Integer value;

    private Integer iteratorDirection = 1;

    private int digitsCount;


    public MyInteger() {
    }

    public MyInteger(Integer value) {
        this.value = value;
        digitsCount = getCountsOfDigits(value);
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
        digitsCount = getCountsOfDigits(value);
    }


    public void setIteratorDirection(Integer iteratorDirection) {
        this.iteratorDirection = iteratorDirection;
    }

    @Override
    public Iterator<Integer> iterator() {

        if (iteratorDirection == 1) {
            return new ReverseDiditIterator();
        }
        return new ForwardDiditIterator();
    }


    private class ReverseDiditIterator implements Iterator<Integer> {

        private int idx;
        private Integer tmpValue;

        @Override
        public boolean hasNext() {
            return idx < digitsCount;
        }

        @Override
        public Integer next() {
            Integer result;

            if (tmpValue == null) {
                tmpValue = value;
            }

            result = tmpValue % 10;
            tmpValue /= 10;
            idx++;
            return result;
        }
    }

    private class ForwardDiditIterator implements Iterator<Integer> {

        private int idx;
        private Integer tmpValue;


        @Override
        public boolean hasNext() {
            return idx < digitsCount;
        }

        @Override
        public Integer next() {
            idx++;
            return (int) getSymbol(value, idx - 1);
        }
    }

    private int getCountsOfDigits(long number) {
        return (number < 10 ? 1 : 1 + getCountsOfDigits(number / 10));
    }

    public long tenPower(long power) {
        return (power < 1 ? 1 : 10 * tenPower(power - 1));
    }

    public long getSymbol(long number, long k) {
        int cnt = 0;
        long dist = digitsCount - k;
        while (cnt < dist - 1) {
            number = number / 10;
            cnt++;
        }
        return number % 10;
    }


}

