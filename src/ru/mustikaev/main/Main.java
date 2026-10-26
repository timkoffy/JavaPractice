package ru.mustikaev.main;

import java.math.BigInteger;
import java.util.List;
import ru.mustikaev.edu.*;
import ru.mustikaev.math.Decimal;
import ru.mustikaev.math.MathUtils;

public class Main {
        public static void main(String[] args) {
                Student s1;
                try {
                        s1 = test3("pete", 1,2,3);
                } catch (InvalidGradeException e) {
                        StackTraceElement[] trace = e.getStackTrace();
                        if ("<init>".equals(trace[0].getMethodName())) {
                                s1 = new Student("pete");
                        } else {
                                System.out.println("Something went wrong");
                                throw new RuntimeException(e);
                        }
                }
                System.out.println(s1);


                // // 3.1.4.
                // if (args.length == 2) {
                //         System.out.println(power(args[0], args[1]));
                // }

                // // 3.1.5.
                // Point p1 = new Point(1, 2);
                // java.awt.Point p2 = new java.awt.Point(1, 2);

                // System.out.println(p1);
                // System.out.println(p2);
        }

        public static Student test3(String name, int... grades) { return null; }

        public static void test1(Student s, int... grades) {
                List<Integer> gradesCopy = s.getGrades();
                try {
                        for (int grade : grades) {
                                s.addGrade(grade);
                        }
                } catch (InvalidGradeException e) {
                        s.setGrades(gradesCopy);
                }
        }

        public static void test2(int grade, Student... students) {
                try {
                        for (Student s : students) {
                                Student s1 = new Student(s);
                                s1.addGrade(grade);
                        }
                } catch (InvalidGradeException e) {
                        return;
                }

                for (Student s : students) {
                        s.addGrade(grade);
                }
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
