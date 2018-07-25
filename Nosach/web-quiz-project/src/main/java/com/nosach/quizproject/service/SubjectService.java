package com.nosach.quizproject.service;

import com.nosach.quizproject.dao.SubjectDAO;
import com.nosach.quizproject.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class SubjectService {

    @Autowired
    SubjectDAO subjectDAO;

    public int addSubject(Subject subject) {
        Subject subj = subjectDAO.save(subject);
        return subj.getId();
    }

    public Subject getSubject(int id) { return subjectDAO.findSubjectById(id); }

    public List<Subject> getAllSubjects() {
        return (List<Subject>) subjectDAO.findAll();
    }

    public int getIdByName(String subj) {
        Subject subject = subjectDAO.findBySubjectName(subj);
        if(subject != null){
            return subject.getId();
        }
        return -1;
    }
}
