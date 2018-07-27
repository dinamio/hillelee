package borysov.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "quizzes")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "subject")
    @NotNull(message = "nameOfSubject required")
    @Size(min = 5)
    private String nameOfSubject;
    @NotNull(message = "theme required")
    @NotEmpty
    private String theme;
    private String author;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfSubject() {
        return nameOfSubject;
    }

    public void setNameOfSubject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Quiz(String nameOfSubject, String theme, String author) {
        this.nameOfSubject = nameOfSubject;
        this.theme = theme;
        this.author = author;
    }

    public Quiz() {
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "nameOfSubject='" + nameOfSubject + '\'' +
                ", theme='" + theme + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
