package ru.mustikaev.connection;

public class ClosedResourceException extends RuntimeException {
    public ClosedResourceException() {
        super("Попытка использовать закрытый ресурс");
    }
}
