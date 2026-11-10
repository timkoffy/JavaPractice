package ru.mustikaev.main;

import ru.mustikaev.Box;
import ru.mustikaev.connection.*;
import ru.mustikaev.edu.Grade;
import ru.mustikaev.edu.IntGrade;
import ru.mustikaev.edu.InvalidGradeException;
import ru.mustikaev.edu.Student;
import ru.mustikaev.geometry.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClosedPolyLine pl1 = new ClosedPolyLine(
                new Point(1, 2),
                new Point(3, 4),
                new Point(5, 6)
        );

        Iterator<Point> iter = pl1.iterator(new Point(3, 4));
        for (int i = 0; i < 10; i++) {
            System.out.println(iter.next());
        }


//                Line<Point> l1 = new Line<>(new Point(1, 3), new Point(3, 5));
//                System.out.println(l1);
//                System.out.println(l1.getBegin().getClass());
//                System.out.println(l1.getEnd().getClass());
//
//                l1.setBegin(new Point3D(4, 5, 6));
//
//                System.out.println(l1);
//                System.out.println(l1.getBegin().getClass());
//                System.out.println(l1.getEnd().getClass());
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

//    public static void addRandomGradeToAll(Student... students) {
//        // 4.2.3
//        int[] randomGrades = new int[students.length];
//        for (int i = 0; i < students.length; i++) {
//            randomGrades[i] = (int) (Math.random() * 10);
//        }
//
//        try {
//            for (int i = 0; i < students.length; i++) {
//                Student s1 = new Student(students[i]);
//                s1.addGrade(randomGrades[i]);
//            }
//        } catch (InvalidGradeException e) {
//            return;
//        }
//
//        for (int i = 0; i < students.length; i++) {
//            students[i].addGrade(randomGrades[i]);
//        }
//    }

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

    public static void setPoint3DToBox(Box<? super Point3D> box) {
        box.setItem(new Point3D(1, 2, 3));
    }

    public static void fillList(List<? super Integer> list) {
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
    }
}