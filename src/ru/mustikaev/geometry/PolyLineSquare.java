package ru.mustikaev.geometry;

public class PolyLineSquare implements PolyLineable {
    private Point rootPoint;
    private int sideLength;

    public PolyLineSquare(Point rootPoint, int sideLength) {
        if (rootPoint == null) {
            throw new NullPointerException("Точка левого верхнего угла не задана");
        }
        this(rootPoint.getX(), rootPoint.getY(), sideLength);
    }

    public PolyLineSquare(int x, int y, int sideLength) {
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

    public PolyLine getPolyLine() {
        return new ClosedPolyLine(
                new Point(rootPoint),
                new Point(rootPoint.getX() + sideLength, rootPoint.getY()),
                new Point(rootPoint.getX() + sideLength, rootPoint.getY() + sideLength),
                new Point(rootPoint.getX(), rootPoint.getY() + sideLength)
                );
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + rootPoint +
                " со стороной " + sideLength;
    }
}
