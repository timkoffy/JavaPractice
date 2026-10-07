package zadachnik.geometry;

public class Rectangle extends Figure {
    protected final double a, b;

    public Rectangle(double a, double b) {
        if (a <= 0 || b <= 0) throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return a * b;
    }
}
