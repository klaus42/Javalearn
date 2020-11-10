package com.javalearn.homework.iterators;

import java.util.Iterator;

public class MyMatrix implements Iterable<Integer> {

    Integer[][] matrix;

    public MyMatrix() {
    }

    public MyMatrix(Integer[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new SpiralArrayIterator(this.matrix);
    }

    private class SpiralArrayIterator implements Iterator<Integer> {

        Integer[] linearArray;
        int idx;

        public SpiralArrayIterator(Integer[][] matrix) {
            linearArray = new Integer[matrix.length * matrix.length];

            int directionX = 1;
            int directiony = 1;


            for (int i = 0; i < matrix.length * matrix.length; i++) {
                if ((i + 1) / 2 <= matrix.length / 2) {
                    directionX = 1;
                } else {
                    directionX = -1;
                }

//                if ()

//                for (int j = 0; j < matrix.length; i++) {
//                    if (i / 2 <= matrix.length / 2) {
//                        direction = 1;
//                    } else {
//                        direction = -1;
//                    }
//
//                }

            }
        }


        @Override
        public boolean hasNext() {
            return idx < matrix.length;
        }

        @Override
        public Integer next() {
            return linearArray[idx++];
        }
    }
}
