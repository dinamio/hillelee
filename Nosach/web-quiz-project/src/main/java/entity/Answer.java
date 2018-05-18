package entity;

public class Answer {

    private String answer;
    private boolean correctness;

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

    public boolean isCorrect() {
        return correctness;
    }

    public void setCorrectness(boolean correctness) {
        this.correctness = correctness;
    }


    @Override
    public String toString() {
        return "Answer{" +
                "answer='" + answer + '\'' +
                ", correctness=" + correctness +
                '}';
    }
}
