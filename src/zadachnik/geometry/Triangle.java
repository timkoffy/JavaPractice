package zadachnik.geometry;

public class Triangle extends Figure {
    private final double a, b, c;

    public Triangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) throw new IllegalArgumentException();

        if (a + b <= c || a + c <= b || b + c <= a){
            throw new IllegalArgumentException("Треугольник не существует");
        }

        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}