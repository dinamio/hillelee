package servlets;

import services.QuizServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {
    private QuizServices services = QuizServices.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("login") != null && req.getSession().getAttribute("pwd") != null) {
        includeJspToPage(req, resp);
        }
    }

    private void includeJspToPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher logoutButton = req.getRequestDispatcher("/logOutButton.jsp");
        RequestDispatcher formDispatcher = req.getRequestDispatcher("/quizCreationForms.jsp");
        RequestDispatcher responseDispatcher = req.getRequestDispatcher("/quizViewTable.jsp");

        /*resp.getWriter().print("<h1>Quizzes</h1>");*/

        logoutButton.include(req, resp);
        formDispatcher.include(req, resp);

        req.setAttribute("list", services.getSubjectQuizList());

        if (!services.getSubjectQuizList().isEmpty()) {
            resp.getWriter().print("<h2>Added quizzes</h2>");
        }

        responseDispatcher.include(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String theme = req.getParameter("Theme");
        String id = req.getParameter("Id");

        if (theme != null && id == null) {

            String subject = req.getParameter("Subject");
            String sessionLogin = (req.getSession().getAttribute("login")).toString();

            services.addNewQuiz(subject, theme, sessionLogin);
        } else {
            services.removeQuizById(id);
        }
        doGet(req, resp);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        //FIXME
        System.out.println("del " + id );
        services.removeQuizById(id);
     /*   resp.sendRedirect("/quiz");*/

        includeJspToPage(req, resp);
    }
}
