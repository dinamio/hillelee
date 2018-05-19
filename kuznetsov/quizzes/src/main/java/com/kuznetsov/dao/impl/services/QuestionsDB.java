package dao.impl.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class QuestionsDB {
    private Connection connection;

    public QuestionsDB(Connection connection) {
        this.connection = connection;
    }

    public void setToDB(int id, Map<String, String> questions) throws SQLException {

        for (Map.Entry<String, String> entry : questions.entrySet()) {
            PreparedStatement statement = connection.prepareStatement("INSERT into questions(quizid, question, answer) VALUES (?,?,?)");
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


}
