package entity;


public class Quiz {

    private Subject subject;
    private String theme;
    private String author;
    private int id = -1; //-1 means id was not set

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

    @Override
    public String toString() {
        return "Quiz{" +
                "subject=" + subject +
                ", theme='" + theme + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
