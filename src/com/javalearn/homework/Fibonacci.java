package com.javalearn.homework;

import java.util.ArrayList;

public class Fibonacci {

    public static ArrayList<Integer> fl;

    public static int fibonacci(int number){
        if (number==2 || number==1){
            return 1;
        }
        return fibonacci(number-1)+fibonacci(number-2);
    }

    public static int getfibposition(int fibNumber){

        int num = 2;

        while (fibNumber>fibonacci(num)){
            num++;
            fibonacci(num);
        }
        return num-1;
    }


    public static void cekendorf(int number){
        if (number<=0){
            return;
        }
        int pos = 1;
        int fib=0;

        int prev=0;
        int prevpos=0;
        do {
            prev=fib;
            prevpos=pos;
            fib = fibonacci(pos);
            pos++;
        } while (fib<=number);
        fl.add(getfibposition(prev));
        cekendorf(number-prev);
    }

    public static void main(String args[]){

        fl = new ArrayList<Integer>();

        cekendorf(100);
        for (int i=fl.get(0);i>0;i--){
            if (fl.indexOf(i)!=-1){
                System.out.print(1);
            } else {
                System.out.print(0);
            }
        }


        System.out.println("");


    }
}
