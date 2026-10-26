package ru.mustikaev.main;

import ru.mustikaev.connection.*;

public class Main {
        public static void main(String[] args) {
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
}