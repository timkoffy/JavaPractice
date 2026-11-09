package ru.mustikaev.edu;

import java.util.Objects;

public class Student<T extends Grade<T>> {
    private String name;
    private Grade<T> grades;

    private Student(String name, Grade grades) {
        this.name = name;
        this.grades = grades;
    }

    public static Student<IntGrade> of(String name, int grade) {
        return new Student<>(name, new IntGrade(grade));
    }

    public static Student<IntGrade> of(String name, IntGrade... grades) {
        return new Student<>(name, new ListIntGrade(grades));
    }

    public Grade<T> getGrades() {
        return grades;
    }

    public void setGrades(Grade<T> grades) {
        this.grades = grades;
    }

    public void addGrade(T grade) {
        grades.addGrade(grade);
    }

    public T getAvgGrade() {
        return grades.averageGrade();
    }

    public boolean isExcellent() {
        return grades.isExcellent();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;

        Student student = (Student) o;
        
        return Objects.equals(name, student.name) 
            && getAvgGrade() == student.getAvgGrade();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getAvgGrade());
    }

    @Override
    public String toString() {
        return name + ": " + grades;
    }

//    @Override
//    public int compare(Student<T> student) {
//        T avgGrade1 = getAvgGrade();
//        T avgGrade2 = student.getAvgGrade();
//
//        if (avgGrade1 > avgGrade2) return 1;
//        if (avgGrade1 < avgGrade2) return -1;
//        return 0;
//    }
}