package Zadachnik;

public final class Decimal {
    private int numerator;
    private int denominator;

    public Decimal(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Знаменатель не может быть равен нулю");
        }

        if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Decimal(Decimal decimal) {
        this.numerator = decimal.numerator;
        this.denominator = decimal.denominator;
    }

    public Decimal add(Decimal operand) {
        Decimal res = new Decimal(this);

        int tmp = operand.numerator;

        tmp *= res.denominator;

        res.numerator *= operand.denominator;
        res.denominator *= operand.denominator;

        res.numerator += tmp;

        res.relax();

        return res;
    }

    public Decimal add(int operand) {
        return add(new Decimal(operand, 1));
    }

    public Decimal sub(Decimal operand) {
        Decimal res = new Decimal(this);

        int tmp = operand.numerator;

        tmp *= res.denominator;

        res.numerator *= operand.denominator;
        res.denominator *= operand.denominator;

        res.numerator -= tmp;

        res.relax();

        return res;
    }

    public Decimal sub(int operand) {
        return sub(new Decimal(operand, 1));
    }

    public Decimal mul(Decimal operand) {
        Decimal res = new Decimal(this);

        res.numerator *= operand.numerator;
        res.denominator *= operand.denominator;

        res.relax();

        return res;
    }

    public Decimal mul(int operand) {
        return mul(new Decimal(operand, 1));
    }

    public Decimal div(Decimal operand) {
        Decimal res = new Decimal(this);

        if (operand.numerator == 0) {
            throw new ArithmeticException("Деление на ноль");
        }

        res.numerator *= operand.denominator;
        res.denominator *= operand.numerator;

        if (res.denominator < 0) {
            res.denominator = -res.denominator;
            res.numerator = -res.numerator;
        }

        res.relax();

        return res;
    }

    public Decimal div(int operand) {
        return div(new Decimal(operand, 1));
    }

    public void relax() {
        int gcd = computeGcd(Math.abs(numerator), Math.abs(denominator));

        numerator /= gcd;
        denominator /= gcd;
    }

    static private int computeGcd(int a, int b) {
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
