package ru.mustikaev.libraly;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Author> authors;

    public Book(String title, List<Author> authors) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.title = title;

        if (authors == null) {
            this.authors = new ArrayList<>();
        } else {
            this.authors = new ArrayList<>(authors);
        }

        for (Author author : this.authors) {
            author.addBook(this);
        }
    }

    public Book(String title, Author... authors) {
        this(title, List.of(authors));
    }

    public Book(String title) {
        this(title, new ArrayList<>());
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        if (title == null || title.isBlank()) {
            return "Информация о книге отсутствует";
        }
        String res = "Книга \"" + title + "\" - ";
        if (authors == null) {
            res += Author.UNKNOWN_AUTHOR;
        } else {
            for (Author author : authors) {
                res += " " + author;

                if (author != authors.getLast()) {
                    res += ", ";
                }
            }
        }

        return res;
    }
}
