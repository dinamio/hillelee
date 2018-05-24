package entity;

import java.util.Set;

public class Question implements Comparable<Question> {
    private static int idCounter =0;
    private int id;
    private String question;
    private Set<String> answer;


    public Question(String question, Set<String> answer){
        this.question= question;
        this.answer=answer;
        id=idCounter++;
    }

    @Override
    public String toString() {
        return id+" "+question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<String> getAnswer() {
        return answer;
    }

    public void setAnswer(Set<String> answer) {
        this.answer = answer;
    }

    @Override
    public int compareTo(Question qu) {
        if( qu.id <this.id)return 1;
        if(qu.id>this.id) return -1;

        return 0;
    }
}
