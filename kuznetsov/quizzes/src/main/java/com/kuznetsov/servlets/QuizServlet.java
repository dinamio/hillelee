package kuznetsov.quizzes.src.main.java.com.kuznetsov.servlets;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("")
public class QuizServlet extends HttpServlet {
    kuznetsov.quizzes.src.main.java.services.QuizServices services = new kuznetsov.quizzes.src.main.java.services.QuizServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher formDispatcher = req.getRequestDispatcher("/quizCreationForms.jsp");
        RequestDispatcher responseDispatcher = req.getRequestDispatcher("/quizViewTable.jsp");
        resp.getWriter().print("<h1>Quizzes</h1>");
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
        String subject = req.getParameter("Subject");
        String id = req.getParameter("Id");

        if (id == null) {
            services.addNewQuiz(subject, theme);
        } else {
            services.removeQuizById(id);
        }
        doGet(req, resp);
    }
}
