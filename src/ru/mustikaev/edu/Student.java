package ru.mustikaev.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private List<Integer> grades;
    private GradeRule rule;

    public Student(String name, GradeRule rule, List<Integer> grades) {
        this.name = name;

        if (rule == null) rule = GradeRule.INSTANCE;
        this.rule = rule;

        validateGrades(grades);
        this.grades = new ArrayList<>(grades);
    }

    public Student(String name, GradeRule rule, Integer... grades) {
        this(name, rule, List.of(grades));
    }

    public Student(String name, List<Integer> grades) {
        this(name, null, grades);
    }

    public Student(String name, Integer... grades) {
        this(name, List.of(grades));
    }

    public Student(String name) {
        this(name, new ArrayList<>());
    }

    public Student(Student student) {
        this(student.name, student.rule, student.grades);
    }


    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    public void setGrades(List<Integer> grades) {
        validateGrades(grades);
        this.grades = new ArrayList<>(grades);
    }

    public void setGrade(int idx, Integer grade) {
        if (!rule.validate(grade)) {
            throw new InvalidGradeException(name, grade);
        }
        grades.set(idx, grade);
    }

    public void addGrade(int grade) {
        if (!rule.validate(grade)) {
            throw new InvalidGradeException(name, grade);
        }
        grades.add(grade);
    }

    public static void addGradeAll(List<Student> students, int grade) {
        List<Student> res = new ArrayList<>();
        for (Student student : students) {
            res.add(new Student(student));
        }

        try {
            for (int i = 0; i < res.size(); i++) {
                res.get(i).addGrade(grade);
            }
        } catch (InvalidGradeException e) {
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            students.get(i).setGrades(res.get(i).getGrades());
        }
    }

    public double getAvgGrade() {
        if (grades == null || grades.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (Integer grade : grades) {
            sum += grade;
        }

        return (double) sum / grades.size();
    }

    public boolean isExcellent() {
        return getAvgGrade() == 5.0;
    }

    private void validateGrades(List<Integer> grades) {
        if (grades == null) {
            throw new NullPointerException("Список оценок null");
        }

        for (Integer grade : grades) {
            if (!rule.validate(grade)) {
                throw new InvalidGradeException(name, grade);
            }
        }
    }

    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj) return true;
    //     if (obj == null || obj.getClass() != getClass()) return false;
    //     Student student = (Student) obj;
    //     List<Integer> gradesCopy = new ArrayList<>(grades);
    //     List<Integer> studGradesCopy = new ArrayList<>(student.grades);
    //     sort(gradesCopy);
    //     sort(studGradesCopy);
    //     return name.equals(student.name) && gradesCopy.equals(studGradesCopy);
    // }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;

        Student student = (Student) o;
        
        return Objects.equals(name, student.name) 
            && getAvgGrade() == student.getAvgGrade();
    }

    // @Override
    // public int hashCode() {
    //     List<Integer> gradesCopy = new ArrayList<>(grades);
    //     sort(gradesCopy);
    //     return Objects.hash(name, gradesCopy);
    // }

    @Override
    public int hashCode() {
        return Objects.hash(name, getAvgGrade());
    }

    @Override
    public String toString() {
        return name + ": " + grades;
    }
}