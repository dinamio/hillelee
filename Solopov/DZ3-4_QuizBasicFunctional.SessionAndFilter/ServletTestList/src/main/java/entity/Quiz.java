package entity;

import entity.Question;

import java.util.TreeSet;
import java.util.Set;

public class Quiz implements Comparable<Quiz>{
    private static int idCounter =0;

    private int id;
    public static Set<Question> questionSet =new TreeSet();
    private String name;
    private String objective;
    private String creator;

    public Quiz(String name, String objective){
        id=idCounter++;
        this.name=name;
        this.objective=objective;

    }



    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    @Override
    public int compareTo(Quiz quiz) {
        if(quiz.id <this.id)return 1;
        if(quiz.id>this.id) return -1;

        return 0;
    }
}
