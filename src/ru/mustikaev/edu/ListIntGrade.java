package ru.mustikaev.edu;

import java.util.ArrayList;
import java.util.List;

public class ListIntGrade extends ArrayList<IntGrade> {
    public static final int MAX = 5;


    public ListIntGrade() {
        this.grades = new ArrayList<>();
    }

    public List<IntGrade> getGrades() {
        return grades;
    }

    @Override
    public void addGrade(IntGrade grade) {
        grades.add(grade);
    }

    @Override
    public IntGrade averageGrade() {
        int res = 0;
        for (IntGrade grade : grades) {
            res += grade.getValue();
        }
        res /= grades.size();
        return new IntGrade(res);
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
