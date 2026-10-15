package zadachnik.math;

public class Math {
    public static double sum(Number... nums) {
        double sum = 0;
        for (Number num : nums) {
            sum += num.doubleValue();
        }
        return sum;
    }
}
