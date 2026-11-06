package ru.mustikaev.geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PolyLine<P extends Point> implements Lengthable {
    private List<P> points;

    public PolyLine(List<P> points) {
        if (points == null || points.size() < 2) {
            throw new IllegalArgumentException("Ломаная должна иметь хотя бы две точки");
        }

        this.points = new ArrayList<>();
        for (P point : points) {
            this.points.add((P) point.clone());
        }

        Class firstType = points.get(0).getClass();
        for (P point : points) {
            if (point.getClass() != firstType) {
                castFloor();
                break;
            }
        }
    }

    public PolyLine(P... points) {
        this(List.of(points));
    }

    public PolyLine(PolyLine pl) {
        this(pl.points);
    }

    public List<P> getPoints() {
        return new ArrayList<>(points);
    }

    public void setPoints(List<P> points) {
        if (points == null || points.size() < 2) {
            throw new IllegalArgumentException("Ломаная должна иметь хотя бы две точки");
        }
        this.points = new ArrayList<>();
        for (P point : points) {
            this.points.add((P) point.clone());
        }
    }

    public void setPoints(P... points) {
        setPoints(List.of(points));
    }

    public P getPoint(int idx) {
        return points.get(idx);
    }

    public P getBegin() {
        return getPoint(points.size() - 1);
    }

    public P getEnd() {
        return getPoint(0);
    }

    public void setPoint(int idx, P p) {
        for (P point : points) {
            if (p.getClass() != point.getClass()) {
                p = (P) new Point(p.getX(), p.getY());
                castFloor();
                break;
            }
        }
        points.set(idx, (P) p.clone());
    }

    public void setPoint(int idx, int x, int y, int z) {
        Point p = new Point3D(x, y, z);
        for (P point : points) {
            if (p.getClass() != point.getClass()) {
                p = new Point(x, y);
            }
        }
        points.set(idx, (P) p);
    }

    public void setBegin(P p) {
        setPoint(0, p);
    }

    public void setEnd(P p) {
        setPoint(points.size() - 1, p);
    }

    public void addPoint(P p) {
        for (P point : points) {
            if (p.getClass() != point.getClass()) {
                castFloor();
            }
        }
        points.add((P) p.clone());
    }

    public List<P> toNormalizedPoints() {
        return new ArrayList<>(points);
    }

    public void castFloor() {
        for (int i = 0; i < points.size(); i++) {
            points.set(i, (P) new Point(
                    points.get(i).getX(),
                    points.get(i).getY()
            ));
        }
    }

    public double length() {
        double res = 0;

        for (int i = 0; i < points.size() - 1; i++) {
            res += points.get(i).dist(points.get(i + 1));
        }

        return res;
    }

    public static PolyLine mergePolyLines(PolyLineable... objs) {
        List<Point> resPoints = new ArrayList<>();
        for (PolyLineable obj : objs) {
            resPoints.addAll(obj.getPolyLine().toNormalizedPoints());
        }
        return new PolyLine(resPoints);
    }

    public List<Line> toLines() {
        return null;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof PolyLine p)) return false;

        List<Line> a = this.toLines();
        List<Line> b = p.toLines();

        if (a.size() != b.size()) return false;
        return a.containsAll(b);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (Line l : toLines()) {
            hash += l.hashCode();
        }
        return hash;
    }

    @Override
    public String toString() {
        return "Линия " + points + "\n  нормализованное: " + toNormalizedPoints();
    }
}
