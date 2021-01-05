package com.javalearn.study.optionals;

import javax.swing.text.html.Option;
import java.util.Optional;

public class OptionExample {

    public static Optional<Double> divide(Double a, Double b) {
        if (b == 0) return Optional.empty();
        else
            return Optional.of(a / b);
    }

    public static void main(String[] args) {

        double a = 1;
        double b = 2;

        Optional<Double> result = divide(a, b);

        System.out.println(result);
        System.out.println(1%2);
    }
}
