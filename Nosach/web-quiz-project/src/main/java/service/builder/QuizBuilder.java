package service.builder;

import entity.Answer;
import entity.Question;
import entity.Quiz;
import entity.Subject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.AnswerService;
import service.QuestionService;
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
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;

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

        //1. Saving Subject to db
       Subject subj = new Subject(this.subject);

       //check Subject for uniqueness
       int subjId =subjectService.getIdByName(subject);
       if(subjId == -1){
           logger.info("Saving subject "+subject+" to db");
           subjId = subjectService.addSubject(subj);
       }

       //2. Saving Quiz
       Quiz quiz = new Quiz(subj, theme, author);
       logger.info("Saving quiz "+theme+" to db");
       int quizId = quizService.addQuiz(quiz, subjId);

       //3.Saving Questions and Answers to DB
       for (String key : map.keySet()) {
           logger.info("Saving question "+key+" to db");
          int questId =  questionService.addQuestion(new Question(key), quizId);

          List<Answer> answers = map.get(key);
           for (Answer answer: answers) {
               logger.info("Saving answer "+answer.getAnswer()+" to db");
               answerService.addAnswer(answer, questId);
           }

       }
   }

   public void clean(){
        this.subject = null;
        this.author = null;
        this.theme = null;
        this.map.clear();
   }



}
