package borysov.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "id_of_quiz")
    private int idOfQuiz;

    @Column(name = "text_question")
    @NotEmpty
    @Size(min = 5, max = 100)
    private String textOfQuestion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOfQuiz() {
        return idOfQuiz;
    }

    public void setIdOfQuiz(int idOfQuiz) {
        this.idOfQuiz = idOfQuiz;
    }

    public String getTextOfQuestion() {
        return textOfQuestion;
    }

    public void setTextOfQuestion(String textOfQuestion) {
        this.textOfQuestion = textOfQuestion;
    }

    public Question() {
    }

    public Question(int id, int idOfQuiz, String textOfQuestion) {
        this.id = id;
        this.idOfQuiz = idOfQuiz;
        this.textOfQuestion = textOfQuestion;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", idOfQuiz=" + idOfQuiz +
                ", textOfQuestion='" + textOfQuestion + '\'' +
                '}';
    }
}
