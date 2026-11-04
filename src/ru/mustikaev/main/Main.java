package ru.mustikaev.main;

import ru.mustikaev.Box;
import ru.mustikaev.connection.*;
import ru.mustikaev.edu.InvalidGradeException;
import ru.mustikaev.edu.Student;
import ru.mustikaev.geometry.Line;
import ru.mustikaev.geometry.Point;

import java.util.ArrayList;
import java.util.List;

public class Main {
        public static void main(String[] args) {
                Box<Integer> box1 = new Box<>(1);
                Box<Double> box2 = new Box<>(0.2);
                Box<Double> box3 = new Box<>(-10.0);

                System.out.println(maxBoxValue(box1, box2, box3));
                System.out.println(box1.getItem());
        }

        public static void task412To421() {
                // 4.1.2 - 4.2.1
                Connection connection = new Connection("ermakov.edu");
                for (int i = 0; i < 10; i++) {
                        try {
                                String data = connection.getData();
                                System.out.println(data);
                        } catch (LostConnectionException | ClosedResourceException e) {
                                System.err.println(e.getMessage());
                        }
                }
                connection.close();
        }

        public static double divideFirstByAll(String... numStrings) {
                // 4.2.2 делить первое на все остальные. не-числа игнорим
                if (numStrings == null || numStrings.length == 0) {
                        throw new IllegalArgumentException();
                }

                double first;
                try {
                        first = Double.parseDouble(numStrings[0]);
                } catch (NumberFormatException e) {
                        throw new IllegalArgumentException();
                }

                for (int i = 1; i < numStrings.length; i++) {
                        try {
                                double num = Double.parseDouble(numStrings[i]);
                                first /= num;
                        } catch (NumberFormatException | ArithmeticException e) {}
                }
                return first;
        }

        public static void addRandomGradeToAll(Student... students) {
                // 4.2.3
                int[] randomGrades = new int[students.length];
                for (int i = 0; i < students.length; i++) {
                        randomGrades[i] = (int) (Math.random() * 10);
                }

                try {
                        for (int i = 0; i < students.length; i++) {
                                Student s1 = new Student(students[i]);
                                s1.addGrade(randomGrades[i]);
                        }
                } catch (InvalidGradeException e) {
                        return;
                }

                for (int i = 0; i < students.length; i++) {
                        students[i].addGrade(randomGrades[i]);
                }
        }

        public static void task424() {
                // 4.2.4
                ExampleConnector connector = new ExampleConnector();
                Connection connection = new Connection("ermakov.edu"); 
                try {
                        connector.makeConnect(connection);
                        System.out.println("success!");
                } catch (LostConnectionException | ClosedResourceException e) {
                        System.out.println("эксепшн в getData()");
                        connector.unregister();
                } catch (RuntimeException e) {
                        System.out.println("эксепшн в register()");
                }
        }

        public static void fillHeap() {
                List<byte[]> garbage = new ArrayList<>();
                try {
                        for (int i = 0; i < 1000; i++) {
                                System.out.println(i);
                                garbage.add(new byte[2 * 1024 * 1024]);
                        }
                } catch (OutOfMemoryError e) {
                        System.out.println("out of memory");
                }
        }

        public static <P extends Point> void moveBeginXBy10(Line<P> line) {
                P begin = line.getBegin();
                begin.setX(begin.getX() + 10);
        }

        public static double maxBoxValue(Box<? extends Number>... boxes) {
                double max = Double.NEGATIVE_INFINITY;

                for (Box<? extends Number> box : boxes) {
                        if (box.isEmpty()) continue;
                        Box<? extends Number> curBox = box.clone();

                        double curValue = curBox.getItem().doubleValue();
                        if (curValue > max) max = curValue;
                }

                return max;
        }
}