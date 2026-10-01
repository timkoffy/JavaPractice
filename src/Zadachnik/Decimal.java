package Zadachnik;

public class Decimal {
    private int numerator;
    private int denominator;

    public Decimal(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Decimal(Decimal decimal) {
        this.numerator = decimal.numerator;
        this.denominator = decimal.denominator;
    }

    public Decimal add(Decimal operand) {
        int tmp = operand.numerator;

        tmp *= this.denominator;

        this.numerator *= operand.denominator;
        this.denominator *= operand.denominator;

        this.numerator += tmp;

        relax();

        return this;
    }

    public Decimal sub(Decimal operand) {
        int tmp = operand.numerator;

        tmp *= this.denominator;

        this.numerator *= operand.denominator;
        this.denominator *= operand.denominator;

        this.numerator -= tmp;

        relax();

        return this;
    }

    public Decimal mul(Decimal operand) {
        this.numerator *= operand.numerator;
        this.denominator *= operand.denominator;

        relax();

        return this;
    }

    public void relax() {
        int gcd = computeGcd(Math.abs(numerator), Math.abs(denominator));

        numerator /= gcd;
        denominator /= gcd;
    }

    private int computeGcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        return a + b;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
