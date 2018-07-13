package controllers;

import dao.QuestionDAOReal;
import dao.QuizDAOReal;
import model.Answer;
import model.Question;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.QuizService;

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

    @RequestMapping(method = GET, value = "questions/{id}")
    public String getFillQuestionList(Model model, @PathVariable("id") Integer id){
        if(id!=null)quizService.setCurrentQuiz(quizDAO.findById(id));
        model.addAttribute("list", quizService.getCurrentQuiz().getQuestions());
        return "QuestionList";
    }

    @RequestMapping(method = GET, value = "questions")
    public String getQuestionList(Model model){
        model.addAttribute("list", quizService.getCurrentQuiz().getQuestions());
        return "QuestionList";
    }

    @RequestMapping(method = GET,value="questions/newquestion")
    public String getNewQuestion(){
        return "Question";
    }

    @RequestMapping(method=POST, value="questions/newquestion")
    public String postAddQuestion(Model model,
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
        quizService.getCurrentQuiz().getQuestions().add(qu);
        quizDAO.update(quizService.getCurrentQuiz());

        return "redirect:/questions";
    }

    @RequestMapping(method = GET, value ="questions/removequestion/{id}")
    public String getRemoveQuestion(@PathVariable("id") int id){
        questionDAO.delete(id);
        return "redirect:/questions";
    }

}
