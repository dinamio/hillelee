package servlet;

import entity.Quiz;
import entity.Subject;
import service.QuizService;
import service.SubjectService;
import service.builder.QuizBuilder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class QuizAddServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Subject> subjects = new SubjectService().getAllSubjects();
        req.setAttribute("subjects", subjects);

        RequestDispatcher rd = req.getRequestDispatcher("/view/quiz-page.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        QuizBuilder quizBuilder;
        HttpSession session = req.getSession();
        if(session.getAttribute("builder") == null){
            quizBuilder = new QuizBuilder();
            session.setAttribute("builder", quizBuilder);
        }else{
            quizBuilder = (QuizBuilder) session.getAttribute("builder");
        }

        String subject;
        if (req.getParameter("subjectList") != ""){
            subject = req.getParameter("subjectList");
        }
        else {
            subject = req.getParameter("subjectInput");
        }
        quizBuilder.addSubject(subject);
        quizBuilder.addTheme(req.getParameter("theme"));
        quizBuilder.addAuthor(req.getSession().getAttribute("login").toString());

        resp.sendRedirect("/question");
    }


}
