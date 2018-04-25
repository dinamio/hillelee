package entity;

public class Quiz {
    private static int  serial = 0;
    private int id;
    private String subject;
    private String theme;
    private String author;

    public Quiz(String subject, String theme, String author) {
        this.subject = subject;
        this.theme = theme;
        this.author = author;
        id = serial++;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "subject='" + subject + '\'' +
                ", theme='" + theme + '\'' +
                '}';
    }
}
