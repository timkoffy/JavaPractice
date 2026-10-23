package ru.mustikaev.math;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class MathUtils {
    public static double sum(Number... nums) {
        double sum = 0;
        for (Number num : nums) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public static double power(String numStr, String powStr) {
        return pow(parseInt(numStr), parseInt(powStr));
    }
}
