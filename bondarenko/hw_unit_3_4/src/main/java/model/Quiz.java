package model;

import java.util.Objects;

public class Quiz {

    private String name;
    private String description;
    private String author;

    public Quiz(String name, String description, String author) {
        this.name = name;
        this.description = description;
        this.author = author;
    }

    public Quiz(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return Objects.equals(name, quiz.name) &&
                Objects.equals(description, quiz.description) &&
                Objects.equals(author, quiz.author);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, description, author);
    }
}
