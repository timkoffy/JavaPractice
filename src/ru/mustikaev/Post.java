package ru.mustikaev;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private final String author;
    private String text;
    private List<Post> comments;

    public Post(String author, String text) {
        this.author = author;
        this.text = text;
        this.comments = new ArrayList<>();
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (!comments.isEmpty()) {
            throw new NotEditablePostException();
        }
        this.text = text;
    }

    public List<Post> getComments() {
        return comments;
    }

    public void addComment(Post comment) {
        this.comments.add(comment);
    }

    public boolean isEditable() {
        return comments.isEmpty();
    }

    @Override
    public String toString() {
        return "Post{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", comments=" + comments +
                '}';
    }
}
