package ru.mustikaev.main;

import ru.mustikaev.math.Decimal;
import ru.mustikaev.math.MathUtils;

import java.math.BigInteger;

import static ru.mustikaev.math.MathUtils.power;

import ru.mustikaev.geometry.Point;

public class Main {
        public static void main(String[] args) {
                // 3.1.4.
                if (args.length == 2) {
                        System.out.println(power(args[0], args[1]));
                }

                // 3.1.5.
                Point p1 = new Point(1, 2);
                java.awt.Point p2 = new java.awt.Point(1, 2);

                System.out.println(p1);
                System.out.println(p2);
        }

        public static void test() {
                // 3.1.3. выражение 7 + 11/3 + 3.21 + 12345678912345678912
                System.out.println(MathUtils.sum(
                        7,
                        new Decimal(11,3),
                        3.21,
                        new BigInteger("12345678912345678912")
                ));
        }
}
