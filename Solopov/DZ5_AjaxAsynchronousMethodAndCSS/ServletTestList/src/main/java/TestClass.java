import hibernate.entity.Question;
import hibernate.entity.Quiz;
import hibernate.service.ServiceQuestion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestClass {

    ServiceQuestion quizQuestion=new ServiceQuestion();

    public static void main(String[] args) {
       new TestClass().meth();
    }

    void meth(){
        List<Question> list=quizQuestion.findAll();
            System.out.print(list);
    }
}
