package zadachnik;

public class Main {
        public static void main(String[] args) {
                System.out.println(
                        zadachnik.math.Math.sum(
                                new Decimal(1, 3),
                                1
                        )
                );
        }

//        public static double sum(Number... nums){
//                double sum = 0;
//                for (Number n : nums) {
//                        sum += n.doubleValue();
//                }
//                return sum;
//        }
//
//        public static Lengthable findMaxLength(Lengthable... objs) {
//                double maxLen = 0;
//                Lengthable maxObj = objs[0];
//                for (Lengthable obj : objs) {
//                        if (obj.length() > maxLen) {
//                                maxObj = obj;
//                                maxLen = obj.length();
//                        }
//                }
//                return maxObj;
//        }
}
