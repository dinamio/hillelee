package Services;

import Entities.QuizTopicBean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuizService {
    private static List<QuizTopicBean> listQuiz = new ArrayList<>();

    public static List<QuizTopicBean> getListQuiz() {
        return listQuiz;
    }

    public static void deleteByIdNoLambda(List<QuizTopicBean> listQuiz, int id) {
        Iterator<QuizTopicBean> iterator = listQuiz.iterator();
        while (iterator.hasNext()) {
            QuizTopicBean quizTopicBean = iterator.next();
            if (quizTopicBean.getId() == id) {
                iterator.remove();
            }
        }
    }

    /* Same thing but with lambda */
    public static void deleteById(List<QuizTopicBean> listQuiz, int id) {
        listQuiz.removeIf(quizTopicBean -> quizTopicBean.getId() == id);
    }
}
