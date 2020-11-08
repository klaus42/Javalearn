package com.javalearn.study.generic;

public class BoxExample {

    private static void fn(Box bx){
        bx.setValue("1234");
    }

    public static void main(String[] args) {
        Box<Integer> box =new Box<>(5);
        //fn(box);
        System.out.println((int)box.getValue()+5);
    }
}

class Box<T>{
    private T value;

    public Box() {
    }

    public Box(T value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class MyArray<T>{
    private T[] arr;

    public MyArray(int size) {
        this.arr = (T[]) new Object[size];
    }
}
