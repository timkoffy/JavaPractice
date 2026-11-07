package ru.mustikaev.edu;

public class InvalidGradeException extends RuntimeException {
    private String name;

    public InvalidGradeException(String name) {
        super("Неправильная оценка для студента " + name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
