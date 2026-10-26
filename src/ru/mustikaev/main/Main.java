package ru.mustikaev.main;

import ru.mustikaev.connection.*;

public class Main {
        public static void main(String[] args) {
                Connection connection = new Connection("https://example.com");
                connection.close();
                try {
                        String data = connection.getData();
                        System.out.println(data);
                } catch (LostConnectionException e) {
                        System.err.println(e.getMessage());
                } catch (ClosedResourceException e) {
                        System.err.println(e.getMessage());
                }
        }
}
