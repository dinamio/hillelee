package servlets;

import services.QuizServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("")
public class QuizServlet extends HttpServlet {
    QuizServices services = new QuizServices();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            try {
                if (services.getSavedCredentials().get(services.getLogin()).equals(services.getPwd())) {


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
            }catch (Exception e){
                System.out.println("it's exeption");

        }}

        @Override
        public void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String theme = req.getParameter("Theme");

            if (theme == null){

                services.setLogin(req.getParameter("login"));
            services.setPwd(req.getParameter("pwd"));

            if (!services.getLogin().equals("") && (!services.getPwd().equals(""))) {


                services.setSavedCredentials(services.getLogin(), services.getPwd());

                req.getSession().setAttribute("login", services.getLogin());
                req.getSession().setAttribute("pwd", services.getPwd());

            } else {

                String subject = req.getParameter("Subject");
                String id = req.getParameter("Id");


                if (id == null) {
                    services.addNewQuiz(subject, theme, String.valueOf(req.getSession().getAttribute("login")));
                } else {
                    services.removeQuizById(id);
                }
            }
                doGet(req, resp);

        }

}}