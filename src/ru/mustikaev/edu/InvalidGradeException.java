package ru.mustikaev.edu;

public class InvalidGradeException extends RuntimeException {
    private int grade;
    private String name;

    public InvalidGradeException(String name, int grade) {
        super("Неправильная оценка " + grade + " для студента " + name);
        this.grade = grade;
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }
}
