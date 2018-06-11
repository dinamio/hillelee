package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "quizzies")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id = -1;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "subjects_id")
    private Subject subject;

    @Column(name = "theme")
    private String theme;

    @Column(name = "author")
    private String author;

    @OneToMany(mappedBy = "quiz", cascade = {CascadeType.ALL})
    private List<Question> questionsList;

    public Quiz() { }

    public Quiz(Subject subject, String theme, String author) {
        this.subject = subject;
        this.theme = theme;
        this.author = author;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Question> getQuestionsList() {
        return questionsList;
    }

    public void addQuestion(Question question){
        if (questionsList == null) {
            questionsList = new ArrayList<>();
        }
        questionsList.add(question);
    }

    public void setQuestionsList (List<Question> questionsList){
        this.questionsList = questionsList;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "subject=" + subject +
                ", theme='" + theme + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
