package Services;

import Entities.QuizTopicBean;

import java.util.ArrayList;
import java.util.List;

public class QuizService {
   public static List<QuizTopicBean> listQuiz = new ArrayList<>();

    public static List<QuizTopicBean> getListQuiz() {
        return listQuiz;
    }

    public static boolean isExisting(String s1, String s2){

        return true;
    }
}
