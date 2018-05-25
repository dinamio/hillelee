package ui.Question;

import entity.Quiz;
import entity.Question;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


public class QuestionAddServlet extends HttpServlet{
    private static Logger log = Logger.getLogger(QuestionAddServlet.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Question.jsp");
        dispatcher.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        boolean formAddTest = Boolean.parseBoolean(request.getParameter("formAddQuestion"));
        log.info(formAddTest);

        if(formAddTest){
            String question = request.getParameter("question");
            String answerLine = request.getParameter("answerLine");
            log.info(question + " "+ answerLine);

            StringTokenizer tokzer=new StringTokenizer(answerLine, "([\\-]{2})");

            Set<String> answerSet=new LinkedHashSet<>();
            while (tokzer.hasMoreTokens()) {
                answerSet.add(tokzer.nextToken().trim());
            }
            Quiz.questionSet.add(new Question(question,answerSet));

            }//end formAddTest
        RequestDispatcher dispatcher = request.getRequestDispatcher("Question.jsp");
        dispatcher.forward(request,response);

    }

}
