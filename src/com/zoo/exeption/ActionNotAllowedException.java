package com.zoo.exeption;

public class ActionNotAllowedException extends Exception{
    public ActionNotAllowedException(String message) {
        super(message);
    }
}
