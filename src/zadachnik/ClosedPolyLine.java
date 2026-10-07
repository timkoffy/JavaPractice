package zadachnik;

import java.util.List;

public class ClosedPolyLine extends PolyLine {
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
    public double length() {
        return super.length() + Point.dist(getPoint(0), getPoint(getPoints().size() - 1));
    }
}