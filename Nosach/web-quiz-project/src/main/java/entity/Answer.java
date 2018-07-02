package entity;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "answer")
    private String answer;

    @Column(name = "correct")
    private boolean correctness;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer() { }

    public Answer(String answer, boolean correctness) {
        this.answer = answer;
        this.correctness = correctness;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isCorrect() {
        return correctness;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer='" + answer + '\'' +
                ", correctness=" + correctness +
                '}';
    }
}
