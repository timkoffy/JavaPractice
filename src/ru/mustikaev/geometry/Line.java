package ru.mustikaev.geometry;

import java.util.Objects;

public class Line<P extends Point> implements Lengthable, Cloneable {
    private P begin;
    private P end;

    public Line(P begin, P end) {
        if (begin == null || end == null) {
            throw new NullPointerException();
        }
        if (begin.getClass() != end.getClass()) {
            begin = (P) new Point(begin.getX(), begin.getY());
            end = (P) new Point(end.getX(), end.getY());
        }
        this.begin = (P) begin.clone();
        this.end = (P) end.clone();
    }

    public Line(Line<P> l) {
        this.begin = (P) l.begin.clone();
        this.end = (P) l.end.clone();
    }

    public static Line<Point> of(int x1, int y1, int x2, int y2) {
        return new Line<>(new Point(x1, y1), new Point(x2, y2));
    }

    public static Line<Point3D> of(int x1, int y1, int z1, int x2, int y2, int z2) {
        return new Line<>(new Point3D(x1, y1, z1), new Point3D(x2, y2, z2));
    }

    public void setBegin(P begin) {
        if (begin == null) throw new NullPointerException();
        if (begin.getClass() != this.end.getClass()) {
            this.begin = (P) new Point(begin.getX(), begin.getY());
            this.end = (P) new Point(this.end.getX(), this.end.getY());
            return;
        }
        this.begin = (P) begin.clone();
    }

    public void setEnd(P end) {
        if (end == null) throw new NullPointerException();
        if (end.getClass() != this.begin.getClass()) {
            this.end = (P) new Point(end.getX(), end.getY());
            this.begin = (P) new Point(this.begin.getX(), this.begin.getY());
            return;
        }
        this.end = (P) end.clone();
    }

    public P getBegin() {
        return begin;
    }

    public P getEnd() {
        return end;
    }

    public double length() {
        return begin.dist(end);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o.getClass() == this.getClass())) {
            return false;
        }

        Line line = (Line) o;

        return (Objects.equals(begin, line.begin) && Objects.equals(end, line.end)) 
            || (Objects.equals(end, line.begin) && Objects.equals(begin, line.end)) ;
    }

    @Override 
    public int hashCode() {
        return Objects.hashCode(end) + Objects.hashCode(begin);
    }

    @Override
    public Line<P> clone() {
        try {
            Line line = (Line) super.clone();

            line.begin = this.begin.clone();
            line.end = this.end.clone();

            return line;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return "Линия от " +
                begin +
                " до " + end;
    }
}
