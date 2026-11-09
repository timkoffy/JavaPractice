package ru.mustikaev.edu;

public interface Grade<T> extends IsExcellentable, Averageable<T> {
    void addGrade(T grade);
    T averageGrade();
    boolean isExcellent();
}