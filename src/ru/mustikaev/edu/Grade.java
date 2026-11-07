package ru.mustikaev.edu;

public abstract class Grade<T extends IsExcellentable & Averageable<T>> implements IsExcellentable, Averageable<T> {
    public abstract void addGrade(T grade);
    public abstract T averageGrade();
    public abstract boolean isExcellent();
}
