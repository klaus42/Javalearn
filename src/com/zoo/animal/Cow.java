package com.zoo.animal;

public class Cow extends Animal{
    public Cow() {
    }

    public Cow(String name, String type, int age) {
        super(name, type, age);
    }

    public void say() {
        System.out.println("Moooo");
    }

    public void getMilk(){
        System.out.println("Надоили 10 литров молока. Они добавлены на склад");
    }
}
