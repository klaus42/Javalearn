package com.zoo.animal;

import com.zoo.exeption.MismatchAnimalTypeException;

public class Dog extends Animal implements Predatorable {

    public Dog() {
    }

    public Dog(String name, String type, int age) {
        super(name, type, age);
    }

    public void say() {
        System.out.println("Woof");
    }

    public void whoAreGoodBoy() {
        this.say();
        this.say();
    }

    public void seeAnimal(Animal animal) {
        if (animal instanceof Cat) {
            int times = (int) (Math.random() * 10);
            for (int i = 0; i < times; i++) {
                this.say();
            }
        }
    }

    @Override
    public void attack(Animal animal) {

        if (animal instanceof Bear){
            try {
                throw new MismatchAnimalTypeException("Не стоит атаковать медведя");
            } catch (MismatchAnimalTypeException e) {
                e.printStackTrace();
            }
        }
        animal.say();
    }
}
