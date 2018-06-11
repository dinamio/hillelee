package borysov.controller;

import borysov.service.QuizService;
import borysov.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ShowQuizzes")
public class ShowQuizzesController extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(ShowQuizzesController.class);
    @Autowired
    QuizService quizService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("ShowQuizzes");

        request.getSession().setAttribute("listOfQuizzes", quizService.getListOfQuizzes());
        response.sendRedirect("showQuizzes.jsp");
    }
}
