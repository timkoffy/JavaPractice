package ru.mustikaev;

public class Box<I> {
    private I item;

    public Box() {
    }

    public Box(I item) {
        this.item = item;
    }

    public void setItem(I item) {
        if (!isEmpty()) {
            throw new BoxNotEmptyException();
        }
        this.item = item;
    }

    public I getItem() {
        I tmp = item;
        item = null;
        return tmp;
    }

    public boolean isEmpty() {
        return this.item == null;
    }
}
