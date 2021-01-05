package com.javalearn.homework.iterators;


/*
* (Итератор) последовательность целых чисел
* с итератором по цифрам десятичного представления чисел (в обратном направлении)
* Дополнительно: в прямом направлении.
*
* метод setIteratorDirection устанавливает направление итератора, 1 - в обратном направлении
*
*/
public class DigitIterator {
    public static void main(String[] args) {
        Integer[] numbers = {122, 4586, 11487, 22, 1458, 2458};

        MyInteger sequence = new MyInteger(1234567);
        sequence.setIteratorDirection(2);

        for (Integer number : sequence) {
            System.out.println(number);
        }

    }

}
