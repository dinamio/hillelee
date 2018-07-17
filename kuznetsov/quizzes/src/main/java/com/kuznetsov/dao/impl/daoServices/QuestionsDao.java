package com.kuznetsov.dao.impl.daoServices;

import com.kuznetsov.entities.Questions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsDao extends CrudRepository<Questions, Integer> {


    /*public void saveQuestionsToBd(Integer themeId, Map<String, Byte> questionMap) {

        for (Map.Entry<String, Byte> entry : questionMap.entrySet()) {
            Transaction transaction = session.beginTransaction();
            session.save(new Questions(themeId, entry.getKey(), entry.getValue()));
            transaction.commit();
        }
    }

    public Map<String, Byte> getQuestionsFromDB(Integer themeId) {

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
    }*/
}
