package Services;

import Entities.QuizTopicBean;

import java.util.ArrayList;
import java.util.List;

public class QuizService {
   private static List<QuizTopicBean> listQuiz = new ArrayList<>();

    public static List<QuizTopicBean> getListQuiz() {
        return listQuiz;
    }

    public static void copyDelete (List<QuizTopicBean> listQuiz, QuizTopicBean resultToCheck){
        List<QuizTopicBean> listQuizCopy = new ArrayList<>();
        for (QuizTopicBean aListQuiz : listQuiz) {
            if (!aListQuiz.equals(resultToCheck)) {
                listQuizCopy.add(aListQuiz);
            }
        }
        listQuiz.clear();
        listQuiz.addAll(listQuizCopy);
    }
}
