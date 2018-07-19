package com.kuznetsov.services;

import com.kuznetsov.dao.impl.daoServices.QuestionsDao;
import com.kuznetsov.entities.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class QuestionHandler {

    @Autowired
    QuestionsDao questionsDao;

    public void saveQuestions(Integer theme, Map<String, Byte> questionMap) {

        for (Map.Entry<String, Byte> entry : questionMap.entrySet()) {
            Questions questions = new Questions(theme, entry.getKey(), entry.getValue());
            questionsDao.save(questions);
        }
    }

    public Map<String, Byte> getQuestions(Integer theme) {

        List<Questions> questionsEntities;
        Map<String, Byte> questions = new HashMap<>();


        questionsEntities =  questionsDao.getAllByTheme(theme);

        for (int i = 0; i < questionsEntities.size(); i++) {
            Questions entry = questionsEntities.get(i);
            questions.put(entry.getQuestion(), entry.getAnswer());
        }
        return questions;
    }
}
