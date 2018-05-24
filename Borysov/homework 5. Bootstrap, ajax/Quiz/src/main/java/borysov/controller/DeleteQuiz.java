package borysov.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import borysov.entity.*;
import borysov.service.QuizService;
import borysov.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebServlet("/DeleteQuiz")
public class DeleteQuiz extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(DeleteQuiz.class);
    @Autowired
    private QuizService quizService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("DeleteQuiz");

        int id = Integer.valueOf(req.getParameter("id_for_delete_field"));
        quizService.removeQuizById(id);
        req.getSession().setAttribute("listOfQuizzes", quizService.getListOfQuizzes());
        resp.sendRedirect("showQuizzes.jsp");

    }
}
