package borysov.entity;

public class Quiz {
    private String nameOfSubject;
    private String theme;

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

    public Quiz(String nameOfSubject, String theme) {
        this.nameOfSubject = nameOfSubject;
        this.theme = theme;
    }

    public Quiz() {
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "nameOfSubject='" + nameOfSubject + '\'' +
                ", theme='" + theme + '\'' +
                '}';
    }
}
