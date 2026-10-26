package ru.mustikaev.geometry;

import java.util.Objects;

public final class Point3D extends Point {
    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public Point3D(Point3D p) {
        this(p.getX(), p.getY(), p.getZ());
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void set(int x, int y, int z) {
        super.set(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    static public double dist(Point3D p1, Point3D p2) {
        return Math.sqrt(
                Math.pow(p2.getX() - p1.getX(), 2) +
                Math.pow(p2.getY() - p1.getY(), 2) +
                Math.pow(p2.getZ() - p1.getZ(), 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o.getClass() == this.getClass())) {
            return false;
        }

        Point3D point = (Point3D) o;

        return getX() == point.getX() 
            && getY() == point.getY() 
            && z == point.z;
    }

    @Override 
    public int hashCode() {
        return Objects.hash(getX(), getY(), z);
    }

    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }
}