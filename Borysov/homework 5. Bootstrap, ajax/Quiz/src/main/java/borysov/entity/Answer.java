package borysov.entity;

public class Answer {

    private int id;
    private int idOfQuation;
    private String text;
    private boolean isRightAnser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOfQuation() {
        return idOfQuation;
    }

    public void setIdOfQuation(int idOfQuation) {
        this.idOfQuation = idOfQuation;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isRightAnser() {
        return isRightAnser;
    }

    public void setRightAnser(boolean rightAnser) {
        isRightAnser = rightAnser;
    }

    public Answer() {
    }

    public Answer(int id, int idOfQuation, String text, boolean isRightAnser) {
        this.id = id;
        this.idOfQuation = idOfQuation;
        this.text = text;
        this.isRightAnser = isRightAnser;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", idOfQuation=" + idOfQuation +
                ", text='" + text + '\'' +
                ", isRightAnser=" + isRightAnser +
                '}';
    }
}
