package ru.mustikaev.edu;

import ru.mustikaev.Comparable;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student<T extends IsExcellentable<T> & Averageable<T>> implements Comparable<Student<T>> {
    private String name;
    private Grade grades;

    private Student(String name, Grade grades) {
        this.name = name;
        this.grades = grades;
    }
    public static Student<IntGrade> of(String name) {
        return new Student<IntGrade>(name, new IntGrade());
    }

//    public Student(String name, T... grades) {
//        this(name, List.of(grades));
//    }
//
//    public Student(Student<T> student) {
//        this(student.name, student.rule, student.grades);
//    }


    public List<T> getGrades() {
        return (List<T>) new ArrayList<>();
    }

    public void setGrades(Grade<T> grades) {
        this.grades = grades;
    }

//    public void setGrade(int idx, T grade) {
//        grades.set(grade);
//    }

    public void addGrade(T grade) {
        grades.addGrade(grade);
    }

//    public static void addGradeAll(List<Student> students, T grade) {
//        List<Student> res = new ArrayList<>();
//        for (Student student : students) {
//            res.add(new Student(student));
//        }
//
//        try {
//            for (int i = 0; i < res.size(); i++) {
//                res.get(i).addGrade(grade);
//            }
//        } catch (InvalidGradeException e) {
//            return;
//        }
//
//        for (int i = 0; i < students.size(); i++) {
//            students.get(i).setGrades(res.get(i).getGrades());
//        }
//    }

    public T getAvgGrade() {
        return (T) grades.averageGrade();
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

    @Override
    public int compare(Student student) {
        double avgGrade1 = getAvgGrade();
        double avgGrade2 = student.getAvgGrade();

        if (avgGrade1 > avgGrade2) return 1;
        if (avgGrade1 < avgGrade2) return -1;
        return 0;
    }
}