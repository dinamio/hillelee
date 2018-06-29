package ui.Question;

import hibernate.entity.Answer;
import hibernate.entity.Question;
import hibernate.service.ServiceQuestion;
import hibernate.service.ServiceQuiz;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import services.QuestionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


public class QuestionAddServlet extends HttpServlet{
    private static Logger log = Logger.getLogger(QuestionAddServlet.class.getName());

    @Autowired
    ServiceQuiz quizService;

    @Autowired
    ServiceQuestion questionService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=UTF-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("Question.jsp");
        dispatcher.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            String question = request.getParameter("titileOfQuestion");
            String answerLine = request.getParameter("answers");
            String rightAnswers = request.getParameter("rightanswers");

            log.info(question + "\n/////\n"+ answerLine+"\n/////\n"+rightAnswers);

            StringTokenizer tokzer=new StringTokenizer(answerLine, "\n");

            List<Answer> answerList=new ArrayList<>();
            while (tokzer.hasMoreTokens()) {
                answerList.add(new Answer(tokzer.nextToken().trim()));
            }
            tokzer=new StringTokenizer(rightAnswers, "\n");
            for (int i=0;tokzer.hasMoreTokens();i++) {
                answerList.get(i).setRight(Boolean.parseBoolean(tokzer.nextToken().trim()));
            }


        List<Question>list = questionService.findAll();
        for (Question question1:list) {
            log.info(question1); }

            Question qu=new Question(question,answerList);
        QuestionService.currentQuiz.getQuestions().add(qu);
            quizService.update(QuestionService.currentQuiz);
            questionService.persist(qu);

         list = questionService.findAll();
        for (Question question1:list) {
            log.info(question1); }

        RequestDispatcher dispatcher = request.getRequestDispatcher("Question.jsp");
        dispatcher.forward(request,response);
        }

}