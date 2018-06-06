package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany (mappedBy = "subject")
    private List<Quiz> quizList;

    @Column(name = "subject")
    private String subjectName;

    public Subject(){}

    public Subject(String subject_name) {
        this.subjectName = subject_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void addQuiz(Quiz quiz){
        if(quizList == null){
            quizList = new ArrayList<>();
        }
        quizList.add(quiz);
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
