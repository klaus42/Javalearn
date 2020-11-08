package com.zoo;

import com.zoo.animal.Animal;
import com.zoo.exeption.AviaryIsFullException;
import com.zoo.exeption.MismatchAnimalTypeException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.SortedMap;

public class Aviary {
    private int size;

    private HashMap<String, Animal> animals;

    private static int aviaryCounts;
    private static int maxAviary=4;

    public Aviary() {
    }

    public Aviary(int size) {
        this.size = size;
        animals = new HashMap<>();
        aviaryCounts++;
    }

    public Aviary(int size, HashMap<String, Animal> animals) {
        this.size = size;
        this.animals = animals;
        aviaryCounts++;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static void setMaxAviary(int maxAviary) {
        Aviary.maxAviary = maxAviary;
    }

    public HashMap<String, Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(HashMap<String, Animal> animals) {
        this.animals = animals;
    }


    public boolean addAnimal(Animal animal) {

        try {
            if (this.animals.containsKey(animal.getType())) {
                throw new MismatchAnimalTypeException("Животное " + animal.getType() + " " + animal.getName() + " уже есть в вольере!");
            } else
            if (this.animals.size() == this.size) {
                throw new AviaryIsFullException("В вольере нет свободных мест!");
            } else {
                animals.put(animal.getType(), animal);

            }
        } catch (MismatchAnimalTypeException | AviaryIsFullException e) {
            System.out.println(e.getMessage());
        }


        return true;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();

        str.append("Сейчас в вольере:\n");
        for (Map.Entry<String, Animal> animal : this.animals.entrySet()) {
            str.append(animal.getKey()).append(" по кличке ").append(animal.getValue().getName()).append(", возраст ").append(animal.getValue().getAge()).append(" лет\n");
        }
        return str.toString();
    }
}
