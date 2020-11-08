package com.zoo.animal;

public abstract class Animal {
    private String name; //имя
    private String type; //вид
    private int age; //возраст


    public Animal() {

    }

    public Animal(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    //Переопределяемый метод
    public abstract void say();

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullInfo() {
        return "Информация о питомце: " + this.type + ", кличка " + this.name + ", возраст " + this.age + " лет";
    }

    public String getShortInfo() {
        return "Информация о питомце: кличка " + this.name + ", возраст " + this.age + " лет";

    }

    public void doSomething(String action){
        System.out.println(action);
    }

    public void doSomething(String action,int count){
        for (int i=0;i<count;i++){
            System.out.println("action = " + action);
        }
    }

}
