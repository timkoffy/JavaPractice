package zadachnik;

import java.util.ArrayList;
import java.util.List;

public class Main {
        public static void main(String[] args) {
                System.out.println();

                Square sq1 = new Square(new Point(0, 0), 2);
                PolyLine pl1 = sq1.getPolyLine();
                ClosedPolyLine cpl1 = (ClosedPolyLine) sq1.getPolyLine();

                System.out.println(sq1);
                System.out.println(pl1);
                System.out.println(pl1.getClass());
                System.out.println(cpl1);
                System.out.println(cpl1.getClass());

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
