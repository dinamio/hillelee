package controllers;

import dao.QuestionDAOReal;
import dao.QuizDAOReal;
import model.Answer;
import model.Question;
import model.Quiz;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.QuizService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class QuestionController {
    private static Logger log = Logger.getLogger(QuestionController.class.getName());

    @Autowired
    QuizDAOReal quizDAO;
    @Autowired
    QuizService quizService;
    @Autowired
    QuestionDAOReal questionDAO;

    @RequestMapping(method = GET, value = "quiz/{id}")
    public String fillQuestionList( Model model, @PathVariable("id") Integer id){
        model.addAttribute("list", quizDAO.findById(id).getQuestions());
        return "QuestionList";
    }

    @RequestMapping(method = GET,value="quiz/{id}/newquestion")
    public String newQuestion(){
        return "Question";
    }

    @RequestMapping(method=POST, value="quiz/{id}/newquestion")
    public String addQuestion(Model model,  @PathVariable("id") Integer quizID,
                                  @RequestParam("titileOfQuestion") String titleOfQuestion,
                                  @RequestParam("answers") String answerLine,
                                  @RequestParam("rightanswers") String rightAnswers){
        StringTokenizer tokzer=new StringTokenizer(answerLine, "\n");

        List<Answer> answerList=new ArrayList<>();
        while (tokzer.hasMoreTokens()) {
            answerList.add(new Answer(tokzer.nextToken().trim()));
        }
        tokzer=new StringTokenizer(rightAnswers, "\n");
        for (int i=0;tokzer.hasMoreTokens();i++) {
            answerList.get(i).setRight(Boolean.parseBoolean(tokzer.nextToken().trim()));
        }
        Question qu=new Question(titleOfQuestion,answerList);
        Quiz currentQuiz=quizDAO.findById(quizID);
        currentQuiz.getQuestions().add(qu);
        quizDAO.update(currentQuiz);

        return "redirect:/quiz/{id}";
    }

    @RequestMapping(method = GET, value ="quiz/{idquiz}/removequestion/{idquesion}")
    public String removeQuestion(@PathVariable("idquesion") int id){
        questionDAO.delete(id);
        return "redirect:quiz/{idquiz}/";
    }

}
