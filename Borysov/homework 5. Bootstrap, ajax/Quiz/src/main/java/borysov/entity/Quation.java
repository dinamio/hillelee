package borysov.entity;

public class Quation {
    private int id;
    private int idOfQuiz;
    private String textOfQuation;

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

    public String getTextOfQuation() {
        return textOfQuation;
    }

    public void setTextOfQuation(String textOfQuation) {
        this.textOfQuation = textOfQuation;
    }

    public Quation() {
    }

    public Quation(int id, int idOfQuiz, String textOfQuation) {
        this.id = id;
        this.idOfQuiz = idOfQuiz;
        this.textOfQuation = textOfQuation;
    }

    @Override
    public String toString() {
        return "Quation{" +
                "id=" + id +
                ", idOfQuiz=" + idOfQuiz +
                ", textOfQuation='" + textOfQuation + '\'' +
                '}';
    }
}
