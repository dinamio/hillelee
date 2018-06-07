package com.kuznetsov.services;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Component
public class QuestionAggregator {

    public Map<String, Byte> createQuestionsMap(HttpServletRequest req) {
        Map<String, Byte> questions = new HashMap<>();
        for (int i = 0; ; i++) {
            String key = req.getParameter("Question" + i);
            if (key != null) {
                questions.put((key), answerLabel(req.getParameter(("Checkbox" + i))));
            } else break;
        }
        return questions;
    }

    private Byte answerLabel(Object s) {
        String answer = String.valueOf(s);

        if (answer.equals("on")) {
            return 1;
        } else {
            return 0;
        }
    }

}
