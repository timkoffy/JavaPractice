package ru.mustikaev.geometry;

import java.util.Objects;

public sealed class Point implements Cloneable permits Point3D {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    static public double dist(Point p1, Point p2) {
        return Math.sqrt(
                Math.pow(p2.getX() - p1.getX(), 2) +
                Math.pow(p2.getY() - p1.getY(), 2));
    }

    @Override 
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o.getClass() == this.getClass())) {
            return false;
        }

        Point point = (Point) o;

        return x == point.x && y == point.y;
    }

    @Override 
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override 
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}
