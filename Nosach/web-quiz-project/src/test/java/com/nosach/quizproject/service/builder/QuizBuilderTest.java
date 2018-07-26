package com.nosach.quizproject.service.builder;

import com.nosach.quizproject.entity.Answer;
import com.nosach.quizproject.entity.Quiz;
import com.nosach.quizproject.entity.Subject;
import com.nosach.quizproject.service.QuizService;
import com.nosach.quizproject.service.SubjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class QuizBuilderTest {

    @InjectMocks
    QuizBuilder quizBuilder = new QuizBuilder();

    @Mock
    QuizService quizService;

    @Mock
    SubjectService subjectService;


    @Test
    public void shouldNotSaveNewSubject(){

        when(subjectService.getIdByName(anyString())).thenReturn(-1);
        when(subjectService.getSubject(any(Integer.class))).thenReturn(new Subject("someNewSubject"));
        when(quizService.addQuiz(any(Quiz.class))).thenReturn(1);

        quizBuilder.addAuthor("author");
        quizBuilder.addQuestion("What is it all about?",
                                    Arrays.asList(
                                            new Answer[]{new Answer("Java", true),
                                                         new Answer("Happiness", false)}));
        quizBuilder.addSubject("someNewSubject");
        quizBuilder.addTheme("jUnit");

        quizBuilder.saveToDB();
    }
}
