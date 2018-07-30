package com.kuznetsov.services;

import com.kuznetsov.dao.impl.daoServices.QuestionsDao;
import com.kuznetsov.entities.Questions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.Silent.class)
public class QuestionHandlerTest {


    @Mock
    private QuestionsDao questionsDao;

    @Test
    public void saveQuestionsTest() {

        questionsDao.save(any(Questions.class));

    }

}