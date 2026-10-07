package zadachnik.geometry;

public class Circle extends Figure {
    private double radius;

    public Circle(double radius) {
        if (radius <= 0) throw new IllegalArgumentException();
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}
