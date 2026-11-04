package ru.mustikaev;

public final class Storage<I> {
    private final I item;
    private final I defaultValue;

    public Storage(I item, I defaultValue) {
        this.item = item;
        if (defaultValue == null)
            throw new NullPointerException("Альтернативное значение не может быть null");
        this.defaultValue = defaultValue;
    }

    public I getItem() {
        if (item == null) return defaultValue;
        return item;
    }
}
