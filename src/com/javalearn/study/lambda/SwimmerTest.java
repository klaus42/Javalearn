package com.javalearn.study.lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

class Swimmer {
    String name;
    Integer age;

    public void swim(Consumer<String> c) {
        c.accept(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

public class SwimmerTest {
    public static void main(String[] args) {
        Swimmer swimmer = new Swimmer();
        swimmer.name = "Steve";
        swimmer.age = 14;
        swimmer.swim(System.out::println);

        Supplier<String> sw = () -> swimmer.getName();

        System.out.println(sw.get());
        BiConsumer<String, Integer> newSwimmerValues = (x, y) -> {
            swimmer.setName(x);
            swimmer.setAge(y);
        };

        newSwimmerValues.accept("Anatoly", 44);
        System.out.println(swimmer);

    }
}
