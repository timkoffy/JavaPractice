package ru.mustikaev.edu;

public class IntGrade implements IsExcellentable, Averageable<IntGrade>{
    private int value;

    public IntGrade(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
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
