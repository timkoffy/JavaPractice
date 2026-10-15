package zadachnik;

import zadachnik.birds.BirdManager;
import zadachnik.birds.Cuckoo;
import zadachnik.birds.Sparrow;
import zadachnik.geometry.Circle;
import zadachnik.geometry.Square;
import zadachnik.geometry.FigureManager;

public class Main {
        public static void main(String[] args) {
                Circle c1 = new Circle(1);
                Circle c2 = new Circle(1);
                zadachnik.geometry.Square sq1 = new Square(1);
                System.out.println(FigureManager.areaAll(c1,c2,sq1));
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
