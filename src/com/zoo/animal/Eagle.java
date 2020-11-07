package com.zoo.animal;

public class Eagle extends Animal implements Flyable {
    public Eagle() {
    }

    public Eagle(String name, String type, int age) {
        super(name, type, age);
    }

    public void say() {
        System.out.println("******Говорит что-то на орлином********");
    }

    @Override
    public void fly() {
        System.out.println("В зоопарке некуда лететь, поэтому полетал 10 минут по клетке");
    }

}
