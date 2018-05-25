package dao.impl.services;

import dao.Connector;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class QuestionsDB {

    public void setToDB(int id, Map<String, String> questions) throws SQLException {

        for (Map.Entry<String, String> entry : questions.entrySet()) {

            PreparedStatement statement = Connector.getConnection().prepareStatement("INSERT into questions(quizid, question, answer) VALUES (?,?,?)");
            statement.setInt(1, id);
            statement.setString(2, entry.getKey());
            statement.setInt(3, getCorrectAnswer(entry.getValue()));
            statement.execute();
            statement.close();
        }
    }

    private int getCorrectAnswer(String value) {

        int correctAnswer = 0;
        if (value.equals("correct")) {
            correctAnswer = 1;
        }
        return correctAnswer;
    }

    private String setCorrectAnswer(int value) {
        if (value == 1) {
            return "correct";
        }
        return "incorrect";
    }

    public Map<String, String> getFromDB(int idFromQuiz) throws SQLException {
        Map<String, String> result = new HashMap<>();

        String query = "Select question, answer from questions where quizid = ?";
        PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, idFromQuiz);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            result.put(rs.getString("question"), setCorrectAnswer(rs.getInt("answer")));
        }
        return result;
    }


}
