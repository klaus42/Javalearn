package com.zoo.animal;

public class Bear extends Animal implements Predatorable{
    public Bear() {
    }

    public Bear(String name, String type, int age) {
        super(name, type, age);
    }

    @Override
    public void say() {
        System.out.println("RRRRRR");
    }

    @Override
    public void attack(Animal animal) {
        animal.say();
    }
}
