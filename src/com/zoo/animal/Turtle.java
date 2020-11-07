package com.zoo.animal;

public class Turtle extends Animal{
    public Turtle() {
    }

    public Turtle(String name, String type, int age) {
        super(name, type, age);
    }

    public void say(){
        System.out.println("Ничего не происходит");
    }

    public void run(){
        System.out.println("Дистанция за день: 40 метров");
    }

    public void swim(){
        System.out.println("Дистанция за день: 15 километров");
    }
}
