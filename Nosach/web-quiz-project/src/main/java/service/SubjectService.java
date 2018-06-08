package service;

import dao.SubjectDAO;
import entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubjectService {

    @Autowired
    @Qualifier("subjectHibernateDao")
    SubjectDAO subjectDAO;

    public int addSubject(Subject subject) {
        return subjectDAO.addSubject(subject);
    }

    public Subject getSubject(int id) {
        return subjectDAO.getSubject(id);
    }

    public List<Subject> getAllSubjects() {
        return subjectDAO.getAllSubjects();
    }

    public int getIdByName(String subj) {
        return subjectDAO.getIdByName(subj);
    }
}
