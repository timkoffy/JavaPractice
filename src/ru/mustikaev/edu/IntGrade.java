package ru.mustikaev.edu;

public class IntGrade implements Grade<IntGrade> {
    public static final int MIN_VALUE = 2;
    public static final int MAX_VALUE = 5;

    private int value;

    public IntGrade(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new InvalidGradeException();
        }
        this.value = value;
    }

    public IntGrade(IntGrade grade) {
        if (grade.value < MIN_VALUE || grade.value > MAX_VALUE) {
            throw new InvalidGradeException();
        }
        this.value = grade.value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void addGrade(IntGrade grade) {
        throw new UnsupportedOperationException("невозможно добавить оценку к IntGrade");
    }

    @Override
    public IntGrade averageGrade() {
        return new IntGrade(value);
    }

    @Override
    public boolean isExcellent() {
        return value == 5;
    }
}
