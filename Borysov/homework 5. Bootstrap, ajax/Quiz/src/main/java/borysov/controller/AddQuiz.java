package borysov.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import borysov.entity.*;
import borysov.service.QuizService;
import borysov.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebServlet("/AddQuiz")
public class AddQuiz extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(AddQuiz.class);
    @Autowired
    private QuizService quizService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("AddQuiz");

        String subject = request.getParameter("subject_field");
        String theme = request.getParameter("theme_field");
        User author = (User) request.getSession().getAttribute("currentUser");

        Quiz quiz = new Quiz(subject, theme, author.getLogin());
        quizService.addQuiz(quiz);

        request.getSession().setAttribute("listOfQuizzes", quizService.getListOfQuizzes());
        response.sendRedirect("showQuizzes.jsp");
    }
}
