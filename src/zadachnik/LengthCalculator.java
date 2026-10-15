package zadachnik;

public class LengthCalculator {
    public static double sum(Lengthable... objs) {
        double sum = 0;
        for (Lengthable obj : objs) {
            sum += obj.length();
        }
        return sum;
    }

    public static Lengthable findMax(Lengthable... objs) {
        double maxLen = 0;
        Lengthable maxObj = objs[0];
        for (Lengthable obj : objs) {
            if (obj.length() > maxLen) {
                maxObj = obj;
                maxLen = obj.length();
            }
        }
        return maxObj;
    }
}
