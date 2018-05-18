package servlets;

import services.QuizServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;


@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {
    Logger logger = Logger.getLogger(QuizServlet.class.getName());
    private QuizServices services = QuizServices.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("login") != null && req.getSession().getAttribute("pwd") != null) {
            includeJspToPage(req, resp);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String theme = req.getParameter("Theme");
        String id = req.getParameter("Id");

        if (theme != null && id == null) {

            String subject = req.getParameter("Subject");
            String sessionLogin = (req.getSession().getAttribute("login")).toString();

            services.addNewQuiz(subject, theme, sessionLogin);
        }
        doGet(req, resp);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp){
        String id = req.getParameter("id");
        logger.info("in doDelete " + id);
        services.removeQuizById(Integer.parseInt(id));
    }

    private void includeJspToPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher logoutButton = req.getRequestDispatcher("/view/logOutButton.jsp");
        RequestDispatcher formDispatcher = req.getRequestDispatcher("/view/quizCreationForms.jsp");
        RequestDispatcher responseDispatcher = req.getRequestDispatcher("/view/quizViewTable.jsp");

        logoutButton.include(req, resp);
        formDispatcher.include(req, resp);

        req.setAttribute("list", services.getSubjectQuizList());

        responseDispatcher.include(req, resp);
    }
}
