package ru.mustikaev.geometry;

import java.util.Objects;

public class Line<P extends Point> implements Lengthable, Cloneable {
    private P begin;
    private P end;

    public Line(P begin, P end) {
        if (begin == null || end == null) {
            throw new NullPointerException();
        }
        this.begin = begin;
        this.end = end;
    }

    public Line(Line l) {
        this.begin = (P) l.begin.clone();
        this.end = (P) l.end.clone();
    }

    public void setBegin(P begin) {
        this.begin.set(begin.getX(), begin.getY());
    }

    public void setEnd(Point end) {
        this.end.set(end.getX(), end.getY());
    }

    public Point getBegin() {
        return begin;
    }

    public Point getEnd() {
        return end;
    }

    public double length() {
        return P.dist(begin, end);
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
    public Line clone() {
        try {
            Line line = (Line) super.clone();

            line.begin = (P) this.begin.clone();
            line.end = (P) this.end.clone();

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
