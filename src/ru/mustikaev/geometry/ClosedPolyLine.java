package ru.mustikaev.geometry;

import java.util.*;

public class ClosedPolyLine<P extends Point> extends PolyLine<P> implements Iterable<P> {
    public ClosedPolyLine(List<P> points) {
        super(points);
    }

    public ClosedPolyLine(P... points) {
        super(points);
    }

    public ClosedPolyLine(PolyLine<P> pl) {
        super(pl);
    }

    @Override
    public List<P> toNormalizedPoints() {
        List<P> res = super.toNormalizedPoints();
        if (res.size() > 2) {
            res.add(res.getFirst());
        }
        return res;
    }

    @Override
    public Iterator<P> iterator() {
        return new ClosedPolyLineIterator(0);
    }

    public Iterator<P> iterator(int offset) {
        return new ClosedPolyLineIterator(offset % getPoints().size());
    }

    public Iterator<P> iterator(P startPoint) {
        List<P> points = getPoints(); // можно через indexOf(startPoint)
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).equals(startPoint)) {
                return new ClosedPolyLineIterator(i);
            }
        }
        throw new NoSuchElementException("Точка не найдена");
    }

    private class ClosedPolyLineIterator implements Iterator<P> {
        private ListIterator<P> listItr;

        public ClosedPolyLineIterator(int offset) {
            listItr = getPoints().listIterator(offset);
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public P next() {
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