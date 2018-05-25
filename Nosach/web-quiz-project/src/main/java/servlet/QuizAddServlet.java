package servlet;

import entity.Quiz;
import entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import service.QuizService;
import service.SubjectService;
import service.builder.QuizBuilder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class QuizAddServlet extends HttpServlet {

    @Autowired
    SubjectService ss;

    @Autowired
    QuizBuilder quizBuilder;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Subject> subjects = ss.getAllSubjects();
        req.setAttribute("subjects", subjects);

        RequestDispatcher rd = req.getRequestDispatcher("/view/quiz-page.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if(session.getAttribute("builder") == null){
            quizBuilder.clean();
            session.setAttribute("builder", quizBuilder);
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
