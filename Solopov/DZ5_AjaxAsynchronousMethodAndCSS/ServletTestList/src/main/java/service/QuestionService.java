package service;

import model.Question;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
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