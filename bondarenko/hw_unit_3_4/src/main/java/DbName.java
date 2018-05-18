import connection.ConnectionUtil;
import dao.Entity;
import dao.Vendor;
import xml.StatementsProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbName {

    public static void main(String[] args) throws SQLException {
//        String s = "select count(1) from pg_class";
//        Connection conn = ConnectionUtil.getConnection();
//        Statement st = conn.createStatement();
//        ResultSet rs = st.executeQuery(s);
//        while(rs.next()){
//            System.out.println(rs.getString(1));
//        }
//        ConnectionUtil.close(conn);

        StatementsProvider.getProvider().getStatements(Vendor.PostgreSQL, Entity.QUIZ);

    }
}
