package com.zoo;

import com.zoo.animal.Cat;
import com.zoo.animal.Dog;
import com.zoo.animal.Eagle;
import com.zoo.exeption.ActionNotAllowedException;
import com.zoo.exeption.MismatchAnimalTypeException;

public class Zoo {

    static {
        int maxAviary = 5;
        Aviary.setMaxAviary(maxAviary);
        Aviary[] aviaries = new Aviary[5];
    }


    public static void main(String[] args) throws ActionNotAllowedException, MismatchAnimalTypeException {
        Aviary aviary = new Aviary(4);
        aviary.addAnimal(new Dog("Kat","Терьер",12));
        aviary.addAnimal(new Dog("Kat","Той-Терьер",12));
        aviary.addAnimal(new Cat("Барсик","Британец",3,true));
        aviary.addAnimal(new Cat("Рыжик","Сиам",3,true));
        aviary.addAnimal(new Cat("Кук","Британец",3,true));
        aviary.addAnimal(new Eagle("Зоркий","Desert Eagle",4));


        System.out.println(aviary);
    }
}
