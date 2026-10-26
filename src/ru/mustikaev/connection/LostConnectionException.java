package ru.mustikaev.connection;

public class LostConnectionException extends Exception {
    public LostConnectionException() {
        super("Потеряно соединение с сервером");
    }

    public LostConnectionException(String message) {
        super(message);
    }

    public LostConnectionException(Throwable cause) {
        super(cause);
    }

    public LostConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
