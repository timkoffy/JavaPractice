package zadachnik;

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

    public Point getPoint(int idx) {
        return points.get(idx);
    }

    public Point getBegin() {
        return getPoint(points.size() - 1);
    }

    public Point getEnd() {
        return getPoint(0);
    }

    public void setPoint(int idx, int x, int y) {
        points.get(idx).set(x, y);
    }

    public void setBegin(int x, int y) {
        setPoint(0, x, y);
    }

    public void setEnd(int x, int y) {
        setPoint(points.size() - 1, x, y);
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
