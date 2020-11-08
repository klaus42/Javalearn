package com.javalearn.homework.iterators;

import java.util.Iterator;

public class MyInteger implements Iterable<Integer>{

    private Integer[] numberSequence;

    public MyInteger() {
    }

    public MyInteger(Integer[] numberSequence) {
        this.numberSequence = numberSequence;
    }

    public Integer[] getNumberSequence() {
        return numberSequence;
    }

    public void setNumberSequence(Integer[] numberSequence) {
        this.numberSequence = numberSequence;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new DigitalIterator(this.numberSequence);
    }


    private class DigitalIterator implements Iterator<Integer> {

        Integer[] sortedSequence;
        int idx;

        public DigitalIterator(Integer[] numberSequence) {
            sortedSequence = bubbleSort(numberSequence);
        }

        @Override
        public boolean hasNext() {
            return (idx<sortedSequence.length);
        }

        @Override
        public Integer next() {
            return sortedSequence[idx++];
        }

        Integer[] bubbleSort(Integer[] arr) {
            int n = arr.length;
            for (int i = 0; i < n-1; i++)
                for (int j = 0; j < n-i-1; j++)
                    if (arr[j] > arr[j+1]) {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
            return arr;
        }

    }
}

