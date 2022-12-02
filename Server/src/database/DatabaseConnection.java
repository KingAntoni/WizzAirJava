package database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private static Object lock=new Object();
    private Connection connection;
    private DatabaseConnection() throws SQLException
    {
        connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/DatabaseWizzAir?currentSchema=public","","");
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance==null)
        {
            synchronized (lock){
            if (instance==null) {
                instance = new DatabaseConnection();
            }
        }}
            return instance;

    }
}
