package ru.mustikaev.main;

import ru.mustikaev.connection.*;
import ru.mustikaev.edu.InvalidGradeException;
import ru.mustikaev.edu.Student;

public class Main {
        public static void main(String[] args) {
                
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
}