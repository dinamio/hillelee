package com.nosach.quizproject.service;

import com.nosach.quizproject.dao.SubjectDAO;
import com.nosach.quizproject.entity.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SubjectServiceTest {

    @InjectMocks
    SubjectService subjectService = new SubjectService();

    @Mock
    SubjectDAO subjectDAO;

    @Test
    public void shouldReturnMinusOneWhenSubjectExist(){
        when(subjectDAO.findBySubjectName(anyString())).thenReturn(null);
        int result;

        result = subjectService.getIdByName("noMatterSubject");

        assertEquals(-1, result);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNpeForAddingNullSubbject(){
        when(subjectDAO.save(null)).thenReturn(null);

        subjectService.addSubject(null);
    }
}
