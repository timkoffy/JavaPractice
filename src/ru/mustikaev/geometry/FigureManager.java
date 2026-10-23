package ru.mustikaev.geometry;

public class FigureManager {
    public static double areaAll(Figure... figs) {
        double sum = 0;
        for (Figure fig : figs) {
            sum += fig.area();
        }
        return sum;
    }
}
