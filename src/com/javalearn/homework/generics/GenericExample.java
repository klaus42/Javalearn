package com.javalearn.homework.generics;

public class GenericExample {
    public static void main(String[] args) {

        MyCollection<Integer> myCollection = new MyCollection<>();
        Integer[] myArray = {15, 14, 198, 345, 926};
        myCollection.setMyCollection(myArray);

        System.out.println(myCollection.getCountbyProperty(a ->
                {
                    if ((int) a % 2 == 1) {
                        return true;
                    }
                    return false;
                }
        ));

    }
}


class MyCollection<T> {
    private T[] myCollection;

    int countByProperty;

    public MyCollection() {
    }

    public MyCollection(T[] mycollection) {
        this.myCollection = mycollection;
    }

    public T[] getMyCollection() {
        return myCollection;
    }


    public void setMyCollection(T[] myCollection) {
        this.myCollection = myCollection;
    }

    public int getCountbyProperty(Checkable property) {
        countByProperty = 0;
        for (T elem : this.myCollection) {
            if (property.check(elem)) {
                countByProperty++;
            }
        }
        return countByProperty;
    }
}

@FunctionalInterface
interface Checkable<T> {
    boolean check(T a);
}