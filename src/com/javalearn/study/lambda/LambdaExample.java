package com.javalearn.study.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExample {
    public <T, R> List<R> map(List<T> origin, Function<T, R> function) {
        List<R> newList = new ArrayList<>();
        for (T elem : origin) {
            newList.add(function.apply(elem));
        }
        return newList;
    }

    static <T> void forEach(List<T> origin, Consumer<T> consumer) {
        for (T elem : origin) {
            consumer.accept(elem);
        }
    }

    static <T> List<T> filter(List<T> origin, Predicate<T> predicate) {

        for (int i = 0; i < origin.size(); ) {
            if (!predicate.test(origin.get(i))) {
                origin.remove(i--);
            }
        }

        return origin;
    }

    static <T> T reduce(List<T> origin, BinaryOperator<T> binaryOperator) {

        for (int i = 0; i < origin.size(); i++) {
            //    binaryOperator.apply()
        }
        return origin.get(0);

    }

    public static Number sumNumber(Number a, Number b) {
        if (a instanceof Double || b instanceof Double) {
            return a.doubleValue() + b.doubleValue();
        }
        return a.intValue() + b.intValue();
    }

    static <T extends Number> T sum(List<T> origin) {
        return reduce(origin, (T a, T b) -> (T) (sumNumber(a, b)));
    }

    static <T> Integer count(List<T> origin, Predicate<T> predicate) {
        int cnt = 0;
        for (T elem : origin
        ) {
            if (predicate.test(elem)) {
                cnt++;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {

    }
}
