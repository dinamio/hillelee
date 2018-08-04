package com.quiz.borysov.quizboot.service;

import com.quiz.borysov.quizboot.dao.QuizDao;
import com.quiz.borysov.quizboot.entity.Quiz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;



    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class QuizServiceTest {

        @MockBean
        QuizService quizService;

        @MockBean
        QuizDao quizDao;

        @Test
        public void shouldGetAllQuizzes() {
            when(quizService.getListOfQuizzes()).thenReturn(asList(new Quiz("name", "theme","author"),new Quiz("name2", "theme2","author2")));
            List<Quiz> quizList = quizService.getListOfQuizzes();
            System.out.println(quizList);
            assertEquals("name2", quizList.get(1).getNameOfSubject());
        }
}
