package ru.mustikaev.geometry;

import java.util.*;
import java.util.function.Consumer;

public class ClosedPolyLine extends PolyLine implements Iterable<Point> {
    public ClosedPolyLine(List<Point> points) {
        super(points);
    }

    public ClosedPolyLine(Point... points) {
        super(points);
    }

    public ClosedPolyLine(PolyLine pl) {
        super(pl);
    }

    @Override
    public List<Point> toNormalizedPoints() {
        List<Point> res = super.toNormalizedPoints();
        if (res.size() > 2) {
            res.add(res.getFirst());
        }
        return res;
    }

    @Override
    public Iterator<Point> iterator() {
        return new ClosedPolyLineIterator(0);
    }

    public Iterator<Point> iterator(int offset) {
        return new ClosedPolyLineIterator(offset % getPoints().size());
    }

    public Iterator<Point> iterator(Point startPoint) {
        List<Point> points = getPoints(); // можно через indexOf(startPoint)
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).equals(startPoint)) {
                return new ClosedPolyLineIterator(i);
            }
        }
        throw new NoSuchElementException("Точка не найдена");
    }

    private class ClosedPolyLineIterator implements Iterator<Point> {
        private ListIterator<Point> listItr;

        public ClosedPolyLineIterator(int offset) {
            listItr = getPoints().listIterator(offset);
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Point next() {
            if (!listItr.hasNext())
                rollback();
            return listItr.next();
        }

        private void rollback() {
            while (listItr.hasPrevious())
                listItr.previous();
        }
    }
}