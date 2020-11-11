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
            int directiony = 0;
            int distX = matrix.length;
            int distY = matrix.length - 1;

            int startX = 0;
            int startY = 0;

            int idx = 0;

            while (idx < matrix.length * matrix.length) {
                for (int i = startX; i < startX+ distX; i++) {
                    linearArray[idx] = matrix[startY][i];
                    idx++;
                }

                distX--;
                startX = startX+distX;

                startY++;

                for (int i = startY; i < startY+distY; i++) {
                    linearArray[idx] = matrix[i][startX];
                    idx++;
                }

                startX--;
                distY--;
                startY = startY+ distY;



                for (int i = startX; i > startX - distX; i--) {
                    linearArray[idx] = matrix[startY][i];
                    idx++;
                }

                startX = startX - distX+1;
                startY--;


                for (int i = startY; i > startY - distY; i--) {
                    linearArray[idx] = matrix[i][startX];
                    idx++;
                }

                startX++;
                startY = startY - distY+1;
                distY--;
                distX--;

            }


//            for (int i = 0; i < matrix.length * matrix.length; i++) {
//                if ((i + 1) / 2 <= matrix.length / 2) {
//                    directionX = 1;
//                } else {
//                    directionX = -1;
//                }
//
//                if ((i + 1) % matrix.length == 0) {
//                    directionX = 0;
//                }
//
//
//            }
        }


        @Override
        public boolean hasNext() {
            return idx < matrix.length * matrix.length;
        }

        @Override
        public Integer next() {
            return linearArray[idx++];
        }
    }
}
