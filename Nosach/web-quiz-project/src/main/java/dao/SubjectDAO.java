package dao;

import entity.Subject;

import java.util.List;

public interface SubjectDAO {

    public int addSubject(Subject subject);
    public Subject getSubject(int id);
    public List<Subject> getAllSubjects();
    public int getIdByName(String subj);
}
