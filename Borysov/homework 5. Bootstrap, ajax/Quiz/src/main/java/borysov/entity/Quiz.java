package borysov.entity;

public class Quiz {
    private String nameOfSubject;
    private String theme;
    private String author;

    public String getNameOfSubject() {
        return nameOfSubject;
    }

    public void setNameOfSubject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
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

    public Quiz(String nameOfSubject, String theme, String author) {
        this.nameOfSubject = nameOfSubject;
        this.theme = theme;
        this.author = author;
    }

    public Quiz() {
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "nameOfSubject='" + nameOfSubject + '\'' +
                ", theme='" + theme + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
