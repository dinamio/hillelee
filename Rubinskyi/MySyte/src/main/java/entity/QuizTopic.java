package entity;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
@Table(name = "quizes")
public class QuizTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "topic")
    private String topic;

    @Column(name = "theme")
    private String theme;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_creator")
    private Registration creator;

    /* Constructors  */
    public QuizTopic(){
    }

    public QuizTopic(Integer id, String subject, String theme, Integer idCreator) {
        this.id = id;
        this.topic = subject;
        this.theme = theme;
    }

    public QuizTopic(int id, String subject, String theme, Registration creator) {
        this.id = id;
        this.topic = subject;
        this.theme = theme;
        this.creator = creator;
    }

    /* Methods */

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        QuizTopic that = (QuizTopic) obj;
        return this.topic.equals(that.topic) && this.theme.equals(that.theme);
    }

    @Override
    public int hashCode() {
        return 31 * 31 * topic.hashCode() + 31 * theme.hashCode();
    }

    @Override
    public String toString() {
        return topic + " " + theme;
    }

    /* Getters and setters */

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getTopic() { return topic; }

    public void setTopic(String testSubject) { this.topic = testSubject; }

    public String getTheme() { return theme; }

    public void setTheme(String testTopic) { this.theme = testTopic; }

    public Registration getCreator() { return creator; }

    public void setCreator(Registration creator) { this.creator = creator; }
}

