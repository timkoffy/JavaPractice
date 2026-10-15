package zadachnik;

import zadachnik.birds.BirdManager;
import zadachnik.birds.Cuckoo;
import zadachnik.birds.Sparrow;

public class Main {
        public static void main(String[] args) {
                Sparrow b1 = new Sparrow();
                BirdManager.singAll(b1, b1);
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
