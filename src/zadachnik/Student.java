package zadachnik;

import java.util.ArrayList;
import java.util.List;

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
            throw new IllegalArgumentException("Оценка не подходит под правило");
        }
        grades.set(idx, grade);
    }

    public void addGrade(int grade) {
        if (!rule.validate(grade)) {
            throw new IllegalArgumentException();
        }
        grades.add(grade);
    }

    public static void addGradeAll(List<Student> students, int grade) {
        List<Student> res = new ArrayList<>(); // через список оценок
        for (Student student : students) {
            res.add(new Student(student));
        }

        try {
            for (int i = 0; i < res.size(); i++) {
                res.get(i).addGrade(grade);
            }
        } catch (IllegalArgumentException e) {
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
            throw new IllegalArgumentException("Список оценок null");
        }

        for (Integer grade : grades) {
            if (!rule.validate(grade)) {
                throw new IllegalArgumentException("Оценка не подходит под правило");
            }
        }
    }

    @Override
    public String toString() {
        return name + ": " + grades;
    }
}
