package dao.impl;

import dao.BookDao;
import entity.Book;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugen on 5/11/18.
 */
public class BookDaoImpl implements BookDao {

    private static Logger logger = Logger.getLogger(BookDao.class);

    private static Connection connection;

    public BookDaoImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "qwerty");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("Can not connect!!");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Book> getAllBooks() {
        List<Book> result = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("Select * from book");
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                result.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void insert(Book book) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT into Book(title,author) VALUES (?,?)");
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            statement.execute();
            //statement.execute(String.format("",book.getName(),book.getAuthor()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
