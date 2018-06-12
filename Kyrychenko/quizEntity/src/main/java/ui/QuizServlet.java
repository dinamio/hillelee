package ui;

import model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import service.QuizService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {
    private static final String ADD_QUIZ_PAGE = "/view/inputQuiz.jsp";
    private static final String VIEW_QUIZ_PAGE = "/view/outputQuiz.jsp";
    @Autowired
    private QuizService quizService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action == null ? "add" : action) {
            case "add":
                req.getRequestDispatcher(ADD_QUIZ_PAGE).include(req, resp);
                break;
            case "view":
                req.setAttribute("list", quizService.getQuizList());
                req.getRequestDispatcher(VIEW_QUIZ_PAGE).include(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String subject = req.getParameter("subject");
        String topic = req.getParameter("topic");
        String user = req.getSession().getAttribute("login").toString();

        quizService.addQuiz(new Quiz(subject, topic, user));
        resp.sendRedirect("/quiz");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("quizID"));
        String subject = req.getParameter("subject");
        String topic = req.getParameter("topic");
        String user = req.getSession().getAttribute("login").toString();

        quizService.update(new Quiz(id, subject, topic, user));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        quizService.deleteQuiz(Integer.parseInt(req.getParameter("quizID")));
    }
}
