package ui.Question;

import entity.Quiz;
import entity.Question;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class QuestionAddServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.process(request, response);
    }





    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().print("Some text");

        response.setContentType("text/html; charset=UTF-8");


        RequestDispatcher dispatcher = request.getRequestDispatcher("Question.jsp");
        dispatcher.forward(request,response);

        boolean formAddTest = Boolean.parseBoolean(request.getParameter("formAddQuestion"));
        System.out.println(formAddTest);

        if(formAddTest){
            String question = request.getParameter("question");
            String answerLine = request.getParameter("answerLine");
            System.out.print(question + " "+ answerLine);

            StringTokenizer tokzer=new StringTokenizer(answerLine, "([\\-]{2})");

            Set<String> answerSet=new LinkedHashSet<>();
            while (tokzer.hasMoreTokens()) {
                answerSet.add(tokzer.nextToken().trim());
            }
            Quiz.questionSet.add(new Question(question,answerSet));

            return;
        }//end formAddTest





    }



}
