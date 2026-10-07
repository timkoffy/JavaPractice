package zadachnik;

public class Line {
    private Point begin;
    private Point end;

    public Line(Point begin, Point end) {
        this(begin.getX(), begin.getY(), end.getX(), end.getY());
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.begin = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    public Line(Line l) {
        this.begin = new Point(l.begin);
        this.end = new Point(l.end);
    }

    public void setBegin(Point begin) {
        this.begin.set(begin.getX(), begin.getY());
    }

    public void setBegin(int x, int y) {
        this.begin.set(x, y);
    }

    public void setEnd(Point end) {
        this.end.set(end.getX(), end.getY());
    }

    public void setEnd(int x, int y) {
        this.end.set(x, y);
    }

    public Point getBegin() {
        return begin;
    }

    public Point getEnd() {
        return end;
    }

    public double length() {
        return Math.sqrt(
                Math.pow(end.getX() - begin.getX(), 2) +
                Math.pow(end.getY() - begin.getY(), 2));
    }

    @Override
    public String toString() {
        return "Линия от " +
                begin +
                " до " + end;
    }
}
