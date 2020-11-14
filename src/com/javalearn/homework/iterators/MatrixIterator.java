package com.javalearn.homework.iterators;

public class MatrixIterator {
    public static void main(String[] args) {

        Integer[][] mtx = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        MyMatrix matrix = new MyMatrix(mtx);
        for (Integer num : matrix
        ) {
            System.out.println(num);

        }
    }
}
