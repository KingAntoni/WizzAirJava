package database;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDAO {
    Connection c;

    public UserDAO()
    {
        try {
            c=DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean login()
    {
       return true;
    }
}
