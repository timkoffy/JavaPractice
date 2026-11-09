package ru.mustikaev.edu;

import java.util.ArrayList;
import java.util.List;

public class ListIntGrade implements Grade<IntGrade> {
    public static final int MIN_VALUE = 2;
    public static final int MAX_VALUE = 5;

    private List<IntGrade> grades;

    public ListIntGrade() {
        this.grades = new ArrayList<>();
    }

    public ListIntGrade(IntGrade... grades) {
        for (IntGrade grade : grades) {
            if (grade.getValue() < MIN_VALUE || grade.getValue() > MAX_VALUE) {
                throw new InvalidGradeException();
            }
        }
        this.grades = new ArrayList<>(List.of(grades));
    }

    public List<IntGrade> getGrades() {
        return new ArrayList<>(grades);
    }

    @Override
    public void addGrade(IntGrade grade) {
        if (grade.getValue() < MIN_VALUE || grade.getValue() > MAX_VALUE) {
            throw new InvalidGradeException();
        }
        grades.add(new IntGrade(grade));
    }

    public void addGrade(int grade) {
        if (grade < MIN_VALUE || grade > MAX_VALUE) {
            throw new InvalidGradeException();
        }
        grades.add(new IntGrade(grade));
    }

    @Override
    public IntGrade averageGrade() {
        int res = 0;
        for (IntGrade grade : grades)
            res += grade.getValue();
        return new IntGrade(res / grades.size());
    }

    @Override
    public boolean isExcellent() {
        for (IntGrade grade : grades) {
            if (!grade.isExcellent()) {
                return false;
            }
        }
        return true;
    }
}
