package com.zoo.exeption;

public class MismatchAnimalTypeException extends Exception {
    public MismatchAnimalTypeException(String message) {
        super(message);
    }
}
