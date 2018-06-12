package hibernate.entity;

import javax.persistence.*;
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name="answer")
    private String answer;
    @Column(name="rightanswer")
    private Boolean right; //true or false answer
    @ManyToOne
    @JoinColumn(name = "id_question")
    private Question question;

    public Answer(){}

    public Answer(String answer, Boolean bool) {
        this.answer = answer;
        this.right = bool;
    }

    public Answer(String answer) {
        this.answer = answer;
    }


    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRight(Boolean right) {
        this.right = right;
    }

    public int getId() { return id; }
    public String getAnswer() { return answer; }
    public Boolean getRight() { return right; }

    @Override
    public String toString() {
        return answer;
    }
}
