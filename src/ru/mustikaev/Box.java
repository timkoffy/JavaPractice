package ru.mustikaev;

public class Box<I> implements Cloneable {
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

    @Override
    public Box<I> clone() {
        try {
            Box<I> box = (Box<I>) super.clone();
            box.item = item;
            return box;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }
}
