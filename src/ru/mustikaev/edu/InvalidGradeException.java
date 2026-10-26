package ru.mustikaev.edu;

public class InvalidGradeException extends RuntimeException {
    private int grade;

    public InvalidGradeException(int grade) {
        this.grade = grade;
        super("Invalid grade with " + grade + " value");
    }

    public int getGrade() {
        return grade;
    }
}
