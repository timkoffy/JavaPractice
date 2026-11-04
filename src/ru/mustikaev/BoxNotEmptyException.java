package ru.mustikaev;

public class BoxNotEmptyException extends RuntimeException {
    public BoxNotEmptyException() {
        super("Коробка уже заполнена");
    }
}
