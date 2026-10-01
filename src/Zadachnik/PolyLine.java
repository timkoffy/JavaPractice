package Zadachnik;

import java.util.ArrayList;
import java.util.List;

public class PolyLine {
    private List<Point> points;

    public PolyLine(List<Point> points) {
        if (points == null || points.size() < 2) {
            throw new IllegalArgumentException("Ломаная должна иметь хотя бы две точки");
        }
        this.points = new ArrayList<>(points);
    }

    public PolyLine(Point... points) {
        this(List.of(points));
    }

    public PolyLine(PolyLine pl) {
        this(pl.points);
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public void setPoints(List<Point> points) {
        if (points == null || points.size() < 2) {
            throw new IllegalArgumentException("Ломаная должна иметь хотя бы две точки");
        }
        this.points = new ArrayList<>(points);
    }

    public void setPoints(Point... points) {
        setPoints(List.of(points));
    }

    public Point getBegin() {
        return points.getFirst();
    }

    public Point getEnd() {
        return points.getLast();
    }

    public Point getPoint(int idx) {
        return points.get(idx);
    }

    public void setPoint(int idx, int x, int y) {
        this.points.get(idx).set(x, y);
    }

    public void addPoint(Point p) {
        this.points.add(new Point(p));
    }

    public double length() {
        double res = 0;

        for (int i = 0; i < points.size() - 1; i++) {
            res += Point.dist(points.get(i), points.get(i + 1));
        }

        return res;
    }

    @Override
    public String toString() {
        return "Линия " + points;
    }
}
