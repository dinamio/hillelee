package com.kuznetsov.dao.impl.daoServices;

import com.kuznetsov.entities.Questions;
import com.kuznetsov.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class QuestionsDao {

    public void saveQuestionsToBd(Integer themeId, Map<String, Byte> questionMap) {

        for (Map.Entry<String, Byte> entry : questionMap.entrySet()) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(new Questions(themeId, entry.getKey(), entry.getValue()));
            transaction.commit();
        }
    }

    public Map<String, Byte> getQuestionsFromDB(Integer themeId) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Questions> questionsEntities;
        Map<String, Byte> questions = new HashMap<>();

        String hql = "from Questions where themeId = :userid";
        Query query = session.createQuery(hql);
        query.setInteger("userid", themeId);
        questionsEntities = query.list();

        for (int i = 0; i < questionsEntities.size(); i++) {
            Questions entry = questionsEntities.get(i);
            questions.put(entry.getQuestion(), entry.getAnswer());
        }
        return questions;
    }
}
