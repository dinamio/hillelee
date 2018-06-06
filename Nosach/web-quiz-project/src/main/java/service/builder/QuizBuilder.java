package service.builder;

import entity.Answer;
import entity.Question;
import entity.Quiz;
import entity.Subject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.QuizService;
import service.SubjectService;

import java.util.*;

@Component
public class QuizBuilder {

    private static final Logger logger = Logger.getLogger(QuizBuilder.class);

    private String subject;
    private String theme;
    private String author;
    private Map<String, List<Answer>> map = new LinkedHashMap<>();

    @Autowired
    private QuizService quizService;
    @Autowired
    private SubjectService subjectService;

    public void addTheme (String theme){
        logger.info("Added theme "+theme+ " to QuizBuilder");
        this.theme = theme;
    }

    public void addSubject (String subject){
        logger.info("Added subject "+subject+ " to QuizBuilder");
        this.subject = subject;
    }

    public void addAuthor(String author){
        logger.info("Added author "+author+ " to QuizBuilder");
        this.author = author;
    }

   public void addQuestion (String question, List<Answer> list){
        logger.info("Adding question "+question);
         map.put(question, list);
   }

   public void saveToDB (){

        //1. Getting Subject
       Subject subj;
       int subjId =subjectService.getIdByName(subject);
       if(subjId == -1){
           subj = new Subject(subject);
           subjId = subjectService.addSubject(subj);
           subj.setId(subjId);
       }else{
           subj = subjectService.getSubject(subjId);
       }

       //2. Creating Quiz graph
       Quiz quiz = new Quiz(subj, theme, author);
       List<Question> questionList = new ArrayList<>();

       //2.1. Creating Questions and Answers and bounding them to Quiz
       for (String key : map.keySet()) {
          List<Answer> answers = map.get(key);
          Question question = new Question();
          for (Answer answer : answers){
              answer.setQuestion(question);
          }
          question.setIssue(key);
          question.setListOfAnswers(answers);
          question.setQuiz(quiz);
          questionList.add(question);
       }

       quiz.setQuestionsList(questionList);
       quiz.setSubject(subj);

       //4. Finally! Saving quiz to DB
       quizService.addQuiz(quiz);

   }

   public void clean(){
        this.subject = null;
        this.author = null;
        this.theme = null;
        this.map.clear();
   }

}
