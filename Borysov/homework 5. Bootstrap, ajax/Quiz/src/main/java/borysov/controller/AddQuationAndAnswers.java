package borysov.controller;

import borysov.entity.Answer;
import borysov.entity.Quation;
import borysov.extractor.ExtractorQuationForm;
import borysov.extractor.impl.ExtractorQuationFormImpl;
import borysov.service.QuizService;
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
import java.util.List;

@WebServlet("/AddQuationAndAnswers")
public class AddQuationAndAnswers extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(AddQuationAndAnswers.class);
    ExtractorQuationForm extractorQuationForm = new ExtractorQuationFormImpl();

    @Autowired
    private QuizService quizService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("get");
        String quizId = req.getParameter("quiz_id");
        req.getSession().setAttribute("quizId",quizId);

        resp.sendRedirect("addQuation.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("post");
        String quizId = (String) req.getSession().getAttribute("quizId");
        String quationText = req.getParameter("text_quation_field");

        List<Answer> answersList =  extractorQuationForm.extract(req);

        quizService.addQuationAndAnswers(Integer.valueOf(quizId),quationText,answersList);

        resp.sendRedirect("showQuizzes.jsp");

    }
}
