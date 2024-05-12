package springbook.user.dao.v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DUserDaoV1 extends UserDaoV1 {
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://scz.tplinkdns.com/springbook", "springbook", "springbook");
        return c;
    }
}
