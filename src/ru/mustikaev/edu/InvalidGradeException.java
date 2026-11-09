package ru.mustikaev.edu;

public class InvalidGradeException extends RuntimeException {
    public InvalidGradeException() {
        super("Невалидная оценка");
    }
}
