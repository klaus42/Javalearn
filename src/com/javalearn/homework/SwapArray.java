package com.javalearn.homework;

public class SwapArray {
    public static void main(String agrs[]){
        int[] ar = {8, 7, 6, 5, 4, 3, 2, 1};

        int[] swapAr = new int[ar.length];
        int idx=ar.length-1;
        for (int n:ar){
            swapAr[idx] = n;
            idx--;
        }

    }


}
