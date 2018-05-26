package services;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Component
public class QuestionAggregator {

    public Map<String, String> createQuestionsMap(HttpServletRequest req) {
        Map<String, String> questions = new HashMap<>();
        for (int i = 0; ; i++) {
            String key = req.getParameter("Question" + i);
            if (key != null) {
                questions.put((key), answerLabel(req.getParameter(("Checkbox" + i))));
            } else break;
        }
        return questions;
    }

    private String answerLabel(Object s) {
        String answer = String.valueOf(s);

        if (answer.equals("on")) {
            return "correct";
        } else {
            return "incorrect";
        }
    }

}
