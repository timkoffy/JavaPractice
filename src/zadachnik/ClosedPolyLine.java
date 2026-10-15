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
    public List<Point> toNormalizedPoints() {
        List<Point> res = super.toNormalizedPoints();
        if (res.size() > 2) {
            res.add(res.getFirst());
        }
        return res;
    }
}