package dao.entities;

import connection.ConnectionUtil;
import dao.Entity;
import dao.Operation;
import dao.Vendor;
import logging.Log;;
import model.User;
import utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public abstract class UserDao extends AbstractEntity {

    public UserDao(Vendor vendor, Entity entity) {
        super(vendor, entity);
    }

    public void create(User user) {
        try (Connection connection = ConnectionUtil.getConnection()){
            Log.writeInfo("Creating is running...");
            PreparedStatement ps = connection.prepareStatement(getStatements().get(Operation.CREATE));
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            JdbcUtils.transactionExecution(connection, ps);
            Log.writeInfo("Deleting finished.");
        } catch (SQLException e) {
            Log.writeError(String.format("Creating error. %", user));
        }
    }


    public Optional<User> get(String name) {
        User user = null;
        try (Connection connection = ConnectionUtil.getConnection()){
            Log.writeInfo(String.format("Start of data extracting. User name: {%s}", name));
            PreparedStatement ps = connection.prepareStatement(getStatements().get(Operation.READ));
            ps.setLong(1, Long.valueOf(name));
            ResultSet rs = ps.executeQuery();
            rs.next();
            user = new User(rs.getString(1), rs.getString(2));
            Log.writeInfo(String.format("Data extracting was finished. User name: {%s}", name));
        } catch (SQLException e) {
            Log.writeError(e,String.format("Unable to load user with id {%s}", name));
        }
        return Optional.ofNullable(user);
    }


    public Collection<User> getAll() {
        Collection<User> users = new ArrayList<>();
        try (Connection conn = ConnectionUtil.getConnection()){
            Log.writeInfo("Start of data extracting...");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(getStatements().get(Operation.READ_ALL));
            while (rs.next()){
                users.add(new User(rs.getString(1), rs.getString(2)));
            }
            Log.writeInfo("Data extracting finished.");
        } catch (SQLException e) {
            Log.writeError(e,"Loading error.");
        }
        return users;
    }


    public void update(User user) {
        try (Connection connection = ConnectionUtil.getConnection()){
            Log.writeInfo("Updating is running...");
            PreparedStatement ps = connection.prepareStatement(getStatements().get(Operation.UPDATE));
            ps.setLong(1, Long.valueOf(user.getName()));
            ps.setLong(2, Long.valueOf(user.getPassword()));
            JdbcUtils.transactionExecution(connection, ps);
            Log.writeInfo("Updating finished");
        } catch (SQLException e) {
            Log.writeError(String.format("Updating error. User : {%s}", user));
        }
    }
}
