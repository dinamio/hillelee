package service;

import dao.SubjectDAO;
import dao.SubjectDAOImpl;
import entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubjectService {

    @Autowired
    SubjectDAO sd;

    public int addSubject(Subject subject) {
        return sd.addSubject(subject);
    }

    public Subject getSubject(int id) {
        return sd.getSubject(id);
    }

    public List<Subject> getAllSubjects() {
        return sd.getAllSubjects();
    }

    public int getIdByName(String subj) {
        return sd.getIdByName(subj);
    }
}
