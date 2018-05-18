package entity;

import java.util.Objects;

public class Subject {

    private String subjectName;

    public Subject(String subject_name) {
        this.subjectName = subject_name;
    }

    public String getSubjectName() {
        return subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subject_name='" + subjectName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(subjectName, subject.subjectName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(subjectName);
    }
}
