package controllers;

import entity.Answer;
import entity.Quiz;
import entity.Subject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import service.QuizService;
import service.SubjectService;
import service.builder.QuizBuilder;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class QuizController {

    private static final Logger logger = Logger.getLogger(QuizController.class);

    @Autowired
    QuizService quizService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    QuizBuilder quizBuilder;

    @RequestMapping(method = GET, value = "list")
    public String showQuizListForm(Model model){
        List<Quiz> list =  quizService.getAllQuizzies();
        model.addAttribute("quizzies", list);
        return "list-of-quizzes";
    }

    @RequestMapping(method = GET, value = "add")
    public String showQuizAddingForm(Model model){
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects);
        return "quiz-page";
    }

    @RequestMapping(method = POST, value = "add")
    public String addQuizBasicInfo(HttpSession session, WebRequest req){
        if(session.getAttribute("builder") == null){
            quizBuilder.clean();
            session.setAttribute("builder", quizBuilder);
        }

        String subject;
        if (req.getParameter("subjectList") != ""){
            subject = req.getParameter("subjectList");
        }
        else {
            subject = req.getParameter("subjectInput");
        }
        quizBuilder.addSubject(subject);
        quizBuilder.addTheme(req.getParameter("theme"));
        quizBuilder.addAuthor(session.getAttribute("login").toString());

        return "redirect:question";
    }

    @RequestMapping(method = GET, value = "question")
    public String showQuestionAddingForm(Model model){
        model.addAttribute("questionsCount", 0);
        return "questions-page";
    }

    @RequestMapping(method = POST, value = "question")
    public String addQuestion (WebRequest req, HttpSession session, Model model){
        String question = req.getParameter("question");

        int i=0;
        List<Answer> listOfAnswers = new ArrayList<>();

        while(req.getParameter("answer"+i) != null ){
            boolean checked = !(req.getParameter("check"+i) == null);
            listOfAnswers.add(new Answer(req.getParameter("answer"+i), checked));
            i++;
        }

        quizBuilder.addQuestion(question, listOfAnswers);

        if (req.getParameter("save") != null){
            logger.info("Saving Quiz to database!!");
            quizBuilder.saveToDB();
            session.setAttribute("builder", null);
            return "redirect:list";
        }

        String count = req.getParameter("questionsCount").toString();
        int next = Integer.parseInt(count)+1;
        model.addAttribute("questionsCount", next);

        return "questions-page";
    }

    @RequestMapping( value = "/delete/{id}", method = GET)
    public String deleteQuiz(@PathVariable("id") int id){
        logger.info("deleting quiz");
        quizService.deleteQuiz(id);
        return "redirect:/list";
    }

}
