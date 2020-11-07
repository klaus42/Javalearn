package com.zoo.animal;

import com.zoo.exeption.ActionNotAllowedException;

public class Cat extends Animal implements Predatorable{


    private boolean purrOn=false;
    public Cat() {

    }

    public Cat(String name, String type, int age, boolean purrOn) {
        super(name, type, age);
        this.purrOn = purrOn;
    }

    public void say(){
        System.out.println("Meow");
    }

    public void makeBite(){
        System.out.println("Кусь");
    }

    public void enablePurr(){
        this.purrOn = true;
    }

    public boolean isPurrEnabled(){
        return this.purrOn;
    }

    /*
    * Если кот в хорошем настроении, он не будет делать "кусь" - выбрасывается исключение
    *
    *
    * */

    @Override
    public void attack(Animal animal) {
        if (this.purrOn){
            try {
                throw new ActionNotAllowedException("Не хочу кусаться!");
            } catch (ActionNotAllowedException e) {
                e.printStackTrace();
            }
        } else {
            makeBite();
        }
    }
}
