package dao;

import dao.connector.DBConnector;
import entity.Subject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class SubjectDAOImpl implements SubjectDAO{

    private static final Logger logger = Logger.getLogger(SubjectDAOImpl.class);

    @Override
    public int addSubject(Subject subj) {
        Connection con = DBConnector.getConnection();
        try {
            String query = "INSERT into subjects (subject) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, subj.getSubjectName());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int subjId = -1;
            if(rs.next())
            {
                subjId = rs.getInt(1);
            }

            logger.info("Inserted subj id ="+ subjId);

            return subjId;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Subject getSubject(int id) {

        Connection  conn = DBConnector.getConnection();

        try {
            String query = "SELECT subject FROM subjects WHERE id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }
            else {
                return new Subject(rs.getString("subject"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Subject> getAllSubjects() {
        Connection  conn = DBConnector.getConnection();
        List<Subject> listOfSubjects = new ArrayList<>();

        try {
            String query = "SELECT * FROM subjects";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }
            else {
                listOfSubjects.add(new Subject(rs.getString("subject")));

                while (rs.next()){
                    listOfSubjects.add(new Subject(rs.getString("subject")));
                }

                return listOfSubjects;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getIdByName(String subj) {
        Connection  conn = DBConnector.getConnection();

        try {
            String query = "SELECT id FROM subjects WHERE subject= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, subj);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return -1;
            }
            else {
                return rs.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
