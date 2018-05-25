package services;

import entity.Question;

import java.util.Set;

public class QuestionService {
    public boolean removeQuestion(Set<Question> quSet, int id){
        Question question = null;
        for (Question qu:quSet)
            if(qu.getId()==id){
                question=qu;
                break;
            }
        return quSet.remove(question);
    }

}
