package model;

import javax.persistence.*;
import java.util.TreeSet;
import java.util.Set;

@Entity
public class Quiz implements Comparable<Quiz>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Question> questions =new TreeSet();

    @Column(name="name")
    private String name;

    @Column(name="objective")
    private String objective;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User creator;

    public Quiz(User creator, String name, String objective){
        this.creator=creator;
        this.name=name;
        this.objective=objective; }
    public Quiz(){}
    public Quiz(Integer id){ this.id=id; }

    public void setId(Integer id){
        this.id=id;
    }
    public void setCreator(User creator) { this.creator = creator; }
    public void setName(String name) {
        this.name = name;
    }
    public void setObjective(String objective) {
        this.objective = objective;
    }
    public void setQuestions(Set<Question> questions) { this.questions = questions; }

    public User getCreator() { return creator; }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getObjective() {
        return objective;
    }
    public Set<Question> getQuestions() { return questions; }

    @Override
    public int compareTo(Quiz quiz) {
        if(quiz.id <this.id)return 1;
        if(quiz.id>this.id) return -1;

        return 0;
    }
}