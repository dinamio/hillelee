package com.kuznetsov;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("")
public class Servlet extends HttpServlet {
    private ArrayList<SubjectTests> subjectTestsList = new ArrayList<SubjectTests>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher formDispatcher = req.getRequestDispatcher("/forms.jsp");
        RequestDispatcher responseDispatcher = req.getRequestDispatcher("/response.jsp");
        resp.getWriter().print("<h1>Tests</h1>");
        formDispatcher.include(req, resp);

        req.setAttribute("list", subjectTestsList);

        if (!subjectTestsList.isEmpty()) {
            resp.getWriter().print("<h2>Added tests</h2>");
        }

        responseDispatcher.include(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String theme = req.getParameter("Theme");
        String subject = req.getParameter("Subject");
        String id = req.getParameter("Id");

        if (id == null) {
            SubjectTests subjectTests = new SubjectTests(subject, theme);
            subjectTestsList.add(subjectTests);

        } else {
            int index = 0;

            for (SubjectTests tests : subjectTestsList) {
                if (tests.getId().equals(id)) {
                    index = subjectTestsList.indexOf(tests);
                    break;
                }
            }
            subjectTestsList.remove(index);
        }
        doGet(req, resp);
    }
}
