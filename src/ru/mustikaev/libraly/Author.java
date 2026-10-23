package ru.mustikaev.libraly;

import java.util.ArrayList;
import java.util.List;

public class Author {
    static public final String UNKNOWN_AUTHOR = "Неизвестный автор";

    private String name;
    private List<Book> books;

    public Author(String name) {
        if (name == null || name.isBlank()) {
            name = UNKNOWN_AUTHOR;
        }
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            name = UNKNOWN_AUTHOR;
        }
        this.name = name;
    }

    public void addBook(Book b) {
        if (b == null) {
            return;
        }

        this.books.addLast(b);
        System.out.println("[added to \"" + name + "\"] " + b.getTitle());
    }

    public String printBooks() {
        String res = name + ":\n";

        for (Book b : books) {
            res += "  - " + b.getTitle() + "\n";
        }
        return res;
    }

    @Override
    public String toString() {
        if (name == null || name.isBlank()) {
            name = UNKNOWN_AUTHOR;
        }
        return name;
    }

}
