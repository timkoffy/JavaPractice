package zadachnik;

import java.util.ArrayList;
import java.util.List;

public class Main {
        public static void main(String[] args) {
                Square sq1 = new Square(new Point(0, 0), 1);
                Square sq2 = new Square(new Point(2, 0), 1);
                Square sq3 = new Square(new Point(-2, 0), 1);
                System.out.println(new PolyLine(PolyLine.mergePolyLines(sq1, sq2, sq3)));
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
