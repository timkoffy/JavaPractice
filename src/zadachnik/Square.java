package zadachnik;

public class Square {
    private Point rootPoint;
    private int sideLength;

    public Square(Point rootPoint, int sideLength) {
        if (rootPoint == null) {
            throw new NullPointerException("Точка левого верхнего угла не задана");
        }
        this(rootPoint.getX(), rootPoint.getY(), sideLength);
    }

    public Square(int x, int y, int sideLength) {
        if (sideLength < 1) {
            throw new IllegalArgumentException("Сторона квадрата должна быть хотя бы длиной 1");
        }
        this.rootPoint = new Point(x, y);
        this.sideLength = sideLength;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        if (sideLength < 1) {
            throw new IllegalArgumentException("Сторона квадрата должна быть хотя бы длиной 1");
        }
        this.sideLength = sideLength;
    }

    public PolyLine toPolyLine() {
        return new PolyLine(
                new Point(rootPoint),
                new Point(rootPoint.getX() + sideLength, rootPoint.getY()),
                new Point(rootPoint.getX() + sideLength, rootPoint.getY() + sideLength),
                new Point(rootPoint.getX(), rootPoint.getY() + sideLength),
                new Point(rootPoint)
                );
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + rootPoint +
                " со стороной " + sideLength;
    }
}
