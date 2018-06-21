package controllers;

import entity.Answer;
import entity.Question;
import entity.Quiz;
import entity.Subject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import service.QuizService;
import service.SubjectService;
import service.builder.QuizBuilder;
import service.builder.StatisticBuilder;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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

    List<Question> questions;
    StatisticBuilder statisticBuilder;

    @RequestMapping(method = POST, value = "available")
    public String showAvailable(){
        return "redirect:available";
    }

    @RequestMapping(method = GET, value = "available")
    public String showAvailableSubjects(Model model){
        List<Subject> list = subjectService.getAllSubjects();
        model.addAttribute("subjects", list);
        Integer totalQuizzies = 0;
        for (Subject subject: list) {
            totalQuizzies += subject.getQuizList().size();
        }
        model.addAttribute("totalQuizzies", totalQuizzies);
        return "available-subjects";
    }

    @RequestMapping(method = GET, value = "list")
    public String showQuizListForm(Model model, @RequestParam("subj")String subj){
        List<Quiz> list;
        if (subj.equals("all")){
            list =  quizService.getAllQuizzies();
        }
        else{
            int id = Integer.parseInt(subj);
            Subject subject = subjectService.getSubject(id);
            list = subject.getQuizList();
        }
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
    public String addQuizBasicInfo(HttpSession session, WebRequest req, Principal principal){
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
        quizBuilder.addAuthor(principal.getName());

        return "redirect:/question";
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
            return "redirect:/available";
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
        return "redirect:/list?subj=all";
    }

    @RequestMapping(value = "/pass/{id}", method = GET)
    public String showQuizPassingPage(Model model, @PathVariable("id") int id){
        Quiz quiz = quizService.getQuiz(id);
        questions = quiz.getQuestionsList();
        int currentQuestion = 0;
        statisticBuilder = new StatisticBuilder();
        statisticBuilder.setQuiz(quiz);
        model.addAttribute("question",questions.get(currentQuestion));
        model.addAttribute("currentQuestion", currentQuestion);
        return "pass-the-quiz";
    }

    @RequestMapping(value = "/pass", method = POST)
    public String passQuiz(Model model, WebRequest request){
        int currentQuestion = Integer.parseInt(request.getParameter("currentQuestion"));

        int i=1;
        while(request.getParameter("checkbox"+i) != null){
            boolean checked = !(request.getParameter("check"+i) == null);
            statisticBuilder.addAnswer(checked);
            i++;
        }
        if(currentQuestion >= questions.size()){
            model.addAttribute("quiz", statisticBuilder.getQuiz());
            model.addAttribute("answers", statisticBuilder.getUserAnswers());
            return "result";
        }

        model.addAttribute("question",questions.get(currentQuestion));
        model.addAttribute("currentQuestion", currentQuestion);
        return "pass-the-quiz";
    }

}
