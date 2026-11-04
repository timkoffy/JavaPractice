package ru.mustikaev;

import java.util.ArrayList;
import java.util.List;

public class Stack<E> {
    private List<E> elements;

    public Stack(List<E> elements) {
        if (elements == null) {
            elements = new ArrayList<>();
        }
        this.elements = new ArrayList<>(elements);
    }

    public Stack(E... elements) {
        this(List.of(elements));
    }

    public Stack() {
        this(new ArrayList<>());
    }

    public E pop() {
        return elements.removeLast();
    }

    public void push(E elem) {
        elements.add(elem);
    }

    public E peek() {
        return elements.getLast();
    }
}
